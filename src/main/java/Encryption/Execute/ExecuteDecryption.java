package Encryption.Execute;

import javax.naming.ContextNotEmptyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ExecuteDecryption extends ExecuteEncryption {
    protected static List<Integer> holdTheKey = new ArrayList<>();
    public static List<String> holdTheInitials = new ArrayList<>();
    public static List<String> finalOutputData = new ArrayList<>();
    protected static Map<Integer, String> keyManipulation = new HashMap<>();
    protected static Map<String, Integer> keyManipulationFirst = new HashMap<>();

    public void decryptionStart(String plainText) {

        int[] dataPassing = {
                subA, subB, subC, subD, subE, subF, subG, subH, subI,
                subJ, subK, subL, subM, subN, subO, subP, subQ, subR,
                subS, subT, subU, subV, subW, subX, subY, subZ, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen,
                Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen, Twenty, Twentyone, Twentytwo, Twentythree, Twentyfour, Twentyfive,
                Twentysix, Twentyseven, Twentyeight, Twentynine, Thirty, Thirtyone, Thirtytwo, Thirtythree, Thirtyfour, Thirtyfive, Thirtysix, Thirtyseven,
                Thirtyeight, Thirtynine, Forty, Fortyone, Fortytwo, Fortythree,Fortyfour,Fortyfive, Fortysix, Fortyseven, Fortyeight, Fortynine, Fifty
                ,Fiftyone,Fiftytwo,Fiftythree,Fiftyfour,Fiftyfive,Fiftysix,Fiftyseven, Fiftyeight, Fiftynine, Sixty
        };

        for (int x = 0; x < 26; x++) {
            holdTheKey.add(dataPassing[x]);
        }

        String[] alphabetsData = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z", "~", "^", "[", "#",
                "@", "*", "%", "{", ":", "}", "<", ">", "|", "\\",
                "_", "]", "$", ";", "!", "=", "+", "-", "1", "2",
                "3", "4", "5", "6", "7", "8", "9", "0", "&", ".",
                ",", "(", ")", "/", "\"", "'", "`", "?",
                "¢", "€", "¥", "^", "°", "§", "∆", "Π", "√",
                "•", "÷", "×", "©", "®", "™", "✓", "£", " ",
        };

        for (int j = 0; j < alphabetsData.length; j++) {
            keyManipulation.put(dataPassing[j], alphabetsData[j]);
            keyManipulationFirst.put(alphabetsData[j], dataPassing[j]);
        }

        for (int k = 0; k < plainText.length(); k++) {
            holdTheInitials.add(String.valueOf(plainText.charAt(k)));
        }

        for (int i = 0; i < plainText.length(); i++) {
            String initial = holdTheInitials.get(i);
            if (keyManipulationFirst.containsKey(initial)) {
                int decryptionKey = keyManipulationFirst.get(initial);
                String decryptedChar = keyManipulation.get(decryptionKey);
                finalOutputData.add(decryptedChar);
            } /*else {
                // If the character is not in the decryption mapping, treat it as a regular character
                finalOutputData.add(initial);
            }*/
        }
    }

    public static void clearData() {
        holdTheInitials.clear();
        finalOutputData.clear();
    }
}
