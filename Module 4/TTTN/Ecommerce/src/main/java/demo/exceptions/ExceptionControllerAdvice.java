package demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = CustomerException.class)
    public final ResponseEntity<String> handleCustomerException(CustomerException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthenticationFailException.class)
    public final ResponseEntity<String> handleAuthenticationException(AuthenticationFailException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductNotExistsException.class)
    public final ResponseEntity<String> handleProductNotExistsException(ProductNotExistsException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
