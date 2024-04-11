package demo.exceptions;

public class AuthenticationFailException extends IllegalAccessException{
    public AuthenticationFailException (String msg){
        super(msg);
    }

}
