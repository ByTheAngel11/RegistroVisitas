package Exceptions;

public class EmptyField extends Exception {
    public EmptyField(String message) {
        super(message);
    }

    public EmptyField() {}

    public EmptyField(String message, Throwable cause) {
        super(message, cause);
    }
}
