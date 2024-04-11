package demo.controller;

import demo.dto.ResponseDto;
import demo.dto.user.SignInDto;
import demo.dto.user.SignInResponseDto;
import demo.dto.user.SignupDto;
import demo.exceptions.AuthenticationFailException;
import demo.exceptions.CustomerException;
import demo.model.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    //signup
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) throws CustomerException {
        return userService.signUp(signupDto);

    }

    //sign in
    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) throws CustomerException, AuthenticationFailException {
        return userService.signIn(signInDto);
    }


}
