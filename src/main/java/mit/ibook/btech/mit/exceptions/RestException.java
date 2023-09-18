package mit.ibook.btech.mit.exceptions;

public class RestException extends RuntimeException{
    public RestException(String message) {
        super(message);
    }

    public RestException(RuntimeException e) {
        super(e);
    }
}
