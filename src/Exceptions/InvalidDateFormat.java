package Exceptions;

public class InvalidDateFormat extends Exception {
    public InvalidDateFormat(String message) {
        super(message);
    }

    public InvalidDateFormat() {}

    public InvalidDateFormat(String message, Throwable cause) {
        super(message, cause);
    }
}
