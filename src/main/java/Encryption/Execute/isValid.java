package Encryption.Execute;

import Encryption.Interfaces.validating;
import Exceptions.Calling.IllegalCharacters.IllegalCharacterException;
import Exceptions.Calling.InvalidValueReference.InvalidValueReferenceException;
import Exceptions.Calling.UnsupportedSymbols.SymbolNotSupportedException;
import lombok.Getter;
import lombok.SneakyThrows;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class isValid implements validating {
    String firstException, secondException, thirdException;
    @SneakyThrows
    @Override
    public boolean isValidEncryption(String plainText) {
        for (int x = 0; x < plainText.length(); x++) {
            char data = plainText.charAt(x);

/*            if (Character.isLowerCase(data)) {
                firstException = ("""
                      Exception in thread "AWT-EventQueue-0" Exceptions.Calling.IllegalCharacters\s
                      IllegalCharacterException: Undefined Data at programmable.GuiVersion.WindowsofChoice\s
                      isValidEncryption at programmable.GuiVersion.WindowsofChoice\s
                      ActionPerformed at java.desktop/javax.swing.plaf.basic.BasicButtonListener.mouseReleased""");
                throw new IllegalCharacterException("Undefined Data");
            }*/
                  /*if (data == '1' || data == '2' || data == '3' ||
                    data == '4' || data == '5' || data == '6' ||
                    data == '7' || data == '8' ||
                    data == '9') {
                secondException = ("""
                                   Exception in Encryption Algorithm :From: \s[InvalidValueReferenceException]
                                   Exceptions.Calling.InvalidValueReference \s[InvalidValueReferenceException]
                                   Exception Occurred: \s[Encryption Must Be PlainText Only (No Numeric Data is Allowed!)]""");
                throw new InvalidValueReferenceException("", new IllegalArgumentException());
            }*/
        }
        return true;
    }
}