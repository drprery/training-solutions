package exceptionmulticatch.converter;

public class InvalidBinaryStringException extends RuntimeException{
    public InvalidBinaryStringException(Throwable e){
        super(e);
    }
}
