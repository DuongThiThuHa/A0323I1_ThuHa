package demo.exceptions;

public class ProductNotExistsException extends IllegalAccessException{
    public ProductNotExistsException(String msg){
        super(msg);
    }
}
