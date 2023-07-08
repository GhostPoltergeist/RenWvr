package Exceptions.Calling.DataInconsistencyException;

public class DataInconsistencyException extends IllegalThreadStateException{
    DataInconsistencyException() {}
    DataInconsistencyException(String message) {super(message);}
    public DataInconsistencyException(Throwable cause) {super(String.valueOf(cause));}
}
