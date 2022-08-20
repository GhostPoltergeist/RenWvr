/*
* Author: Cabaluna, Harold Edsel F.
* GhostPoltergeist(c) 2022
* */

package com.GhostPoltergeist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Encryption {
    public static void main(String[] args) throws IOException {startEncrypt();}
    private static void startEncrypt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BUFFEREDREADER FOR MORE ACCURATE SCANS OF "STRING"
        String instruction = """
                 _______________________________________________________________________________________________________
                | WELCOME TO GUIDELINES                                                                                 |
                |       [PLAIN TEXT GUIDELINES]                                                                         |
                |                <> ALL THE TEXT THAT YOU WILL INPUT MUST BE ALL UPPERCASE                              |
                |                <> LIST OF RESTRICTIONS                                                                |
                |                NOT ALLOWED!!                                                                          |
                |                  - 'SYMBOLS' / 'PERIODS'                                                              |
                |                  - 'SPACES' / 'WHITE SPACES'                                                          |
                |                  - 'NUMBERS' > [DECIMALS, WHOLE-NUMBERS, ETC]                                         |
                |                  - 'QUERIES'                                                                          |
                |       [ENCRYPTION LEVEL GUIDELINES]                                                                   |
                |                <> NO SYMBOLS, OR ANY TEXT ALLOWED                                                     |
                |                <> INPUT MUST BE INTEGER/WHOLE NUMBER                                                  |
                | [x] REN(WVR) provides temporary Message Security                                                      |
                |    The 'Keys' provided is just a part of System Security.                                             |
                |    'Please Be Guided'                                                                                 |
                | [x] "TYPE 'dec' to Proceed in Decryption Area"                                                        |
                |_______________________________________________________________________________________________________|
                """; //PROVIDING RUNTIME INSTRUCTION : PLEASE BE GUIDED
        for (int i = 0; i < instruction.length(); i++) {
            System.out.print(instruction.charAt(i));
        } //PRINTING INSTRUCTIONS with FOR LOOP

        System.out.println("\n");
        System.out.print("PlainText: ");
        String plainText = reader.readLine();
        //-----
        if (plainText.equals("dec")) {
            EncryptionRange.proceedDecryption(plainText);
        } else if (plainText.equals("mandec")) {
            ManualDec.decryptPlainText();
            System.exit(0);
        }
        //-----
        System.out.println("[1][2][3][4]");
        System.out.print("EncryptionLevel: ");
        int digitNumber = Integer.parseInt(reader.readLine());

         //CHECK IF THERE IS A 'SINGLE LOWERCASE LETTER IN THE PLAINTEXT
         //IF "SATISFIED" EXIT [ELSE] PROCEED
         for (int i=0; i<plainText.length(); i++) {
             char data = plainText.charAt(i);
             if (Character.isLowerCase(data)) {
                 throw new IllegalEncryptionCharacterException("Read The Guidelines properly and Try Again. Something went wrong on the data process",
                 new IllegalArgumentException());
             }
         }
        if (digitNumber == 1 || digitNumber == 2 || digitNumber == 3 || digitNumber == 4) {
            new EncryptionRange(plainText, digitNumber);
        } else {
            throw new EncryptionLevelUnreachableException("Sorry, I can't Reach that Encryption Level");
        }
    }
}