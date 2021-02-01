package collectionsqueue.job;


public class NoJobException extends RuntimeException {
    private final String message;

    public NoJobException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
