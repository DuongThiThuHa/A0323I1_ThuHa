package demo.exceptions;

public class CustomerException extends IllegalAccessException{
    public CustomerException(String msg){
        super(msg);
    }
}
