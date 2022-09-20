package Exceptions.Calling.UnsupportedSymbols;


import java.security.InvalidKeyException;

public class SymbolNotSupportedException extends InvalidKeyException {
    public SymbolNotSupportedException(String message) {super(message);}
    public SymbolNotSupportedException(Throwable cause) {super(cause);}
    public SymbolNotSupportedException(String message, Throwable cause) {super(message, cause);}
}
