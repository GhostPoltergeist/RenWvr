package com.GhostPoltergeist;

import java.util.InputMismatchException;

public class EncryptionLevelUnreachableException extends InputMismatchException {
    EncryptionLevelUnreachableException() {}

    EncryptionLevelUnreachableException(String message) {
        super(message);
    }
}
