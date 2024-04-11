package demo.service;

import demo.dto.ResponseDto;
import demo.dto.user.SignInDto;
import demo.dto.user.SignInResponseDto;
import demo.dto.user.SignupDto;
import demo.exceptions.AuthenticationFailException;
import demo.exceptions.CustomerException;
import demo.model.AuthenticationToken;
import demo.model.User;
import demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    public ResponseDto signUp(SignupDto signupDto) throws CustomerException {
        //check if user is already present
        if (Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))) {
            // we have a user
            throw new CustomerException("User already present!");
        }

        //hash the password
        String encrytedpassword = signupDto.getPassword();
        try {
            encrytedpassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        // save the user
        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encrytedpassword);
        userRepo.save(user);


        // create the token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);

        ResponseDto responseDto = new ResponseDto("success", "user created successfully! ");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signupDto) throws AuthenticationFailException, CustomerException {
        //find user by email
        User user = userRepo.findByEmail(signupDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("User is not valid");
        }

        //hash the password
        try {
            if (!user.getPassword().equals(hashPassword(signupDto.getPassword()))) {
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationService.getToken(user);
        if (Objects.isNull(token)) {
            throw new CustomerException("Token is not present");
        }

        return new SignInResponseDto("Success", token.getToken());
    }
}
