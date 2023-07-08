package Exceptions.Calling.IllegalCharacters;

import java.util.InputMismatchException;

public class IllegalCharacterException extends InputMismatchException {
 public IllegalCharacterException() {}
 public IllegalCharacterException(String message) {super(message);}
}
