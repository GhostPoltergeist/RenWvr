package Exceptions.Calling.IllegalDataSubmmitted;

public class IllegalDataSubmittedException extends IllegalArgumentException {
    public IllegalDataSubmittedException() {}
    IllegalDataSubmittedException(String message) {super(message);}
    IllegalDataSubmittedException(Throwable cause) {super(cause);}
    public IllegalDataSubmittedException(String message, Throwable cause) {super(message, cause);}
}
