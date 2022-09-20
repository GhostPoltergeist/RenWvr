package Exceptions.Calling.InvalidValueReference;

public class InvalidValueReferenceException extends IllegalArgumentException {
    public InvalidValueReferenceException() {}
    public InvalidValueReferenceException(String message) {super(message);}
    public InvalidValueReferenceException(Throwable cause) {super(cause);}
    public InvalidValueReferenceException(String message, Throwable cause) {super(message, cause);}
}
