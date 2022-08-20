package com.GhostPoltergeist;

public class IllegalEncryptionCharacterException extends IllegalArgumentException {
    IllegalEncryptionCharacterException() {}

    IllegalEncryptionCharacterException(String message) {
        super(message);
    }
    IllegalEncryptionCharacterException(Throwable cause) {
        super(cause);
    }
    IllegalEncryptionCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
}
