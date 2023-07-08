package Encryption.Execute;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class ExecuteEncryption extends isValid {
    public static List<Integer> getEncryptedData() {return encryptedData;}
    public static List<Integer> encryptedData = new ArrayList<>();
    public static int outputEnc;
    public static int subA, subB, subC, subD, subE, subF, subG, subH, subI,
            subJ, subK, subL, subM, subN, subO, subP, subQ, subR,
            subS, subT, subU, subV, subW, subX, subY, subZ, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen,
            Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen, Twenty, Twentyone, Twentytwo, Twentythree, Twentyfour, Twentyfive,
            Twentysix, Twentyseven, Twentyeight, Twentynine, Thirty, Thirtyone, Thirtytwo, Thirtythree, Thirtyfour, Thirtyfive, Thirtysix, Thirtyseven,
            Thirtyeight, Thirtynine, Forty, Fortyone, Fortytwo, Fortythree,Fortyfour,Fortyfive, Fortysix, Fortyseven, Fortyeight, Fortynine, Fifty
            ,Fiftyone,Fiftytwo,Fiftythree,Fiftyfour,Fiftyfive,Fiftysix,Fiftyseven, Fiftyeight, Fiftynine, Sixty
            ;
    public static HashMap<String, Integer> encryptionData = new HashMap<>();
    public static HashMap<char[], Integer> asciiValue = new HashMap<char[], Integer>();

    public static String[] alphabetsData =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
             "K", "L", "M", "N", "O", "P", "Q", "R", "S",
             "T", "U", "V", "W", "X", "Y", "Z", "~", "^", "[", "#",
             "@", "*", "%", "{", ":", "}", "<", ">", "|", "\\",
             "_", "]", "$", ";", "!", "=", "+", "-", "1", "2",
             "3", "4", "5", "6", "7", "8", "9", "0", "&", ".",
             ",", "(", ")", "/", "\"", "'", "`", "?",
             "¢", "€", "¥", "^", "°", "§", "∆", "Π", "√",
             "•", "÷", "×", "©", "®", "™", "✓", "£", " ",};
    static List<String> dataStoring = new ArrayList<>();

    int digitNumber;

    @SneakyThrows
    public void runEncryption(String plainText) {
        Random rand = new Random();
        for (String alphabetsDatum : alphabetsData) {
            encryptionData.put(alphabetsDatum, rand.nextInt(10000) * rand.nextInt(20) - rand.nextInt(20));
        }
        subA = encryptionData.get("A");
        subB = encryptionData.get("B");
        subC = encryptionData.get("C");
        subD = encryptionData.get("D");
        subE = encryptionData.get("E");
        subF = encryptionData.get("F");
        subG = encryptionData.get("G");
        subH = encryptionData.get("H");
        subI = encryptionData.get("I");
        subJ = encryptionData.get("J");
        subK = encryptionData.get("K");
        subL = encryptionData.get("L");
        subM = encryptionData.get("M");
        subN = encryptionData.get("N");
        subO = encryptionData.get("O");
        subP = encryptionData.get("P");
        subQ = encryptionData.get("Q");
        subR = encryptionData.get("R");
        subS = encryptionData.get("S");
        subT = encryptionData.get("T");
        subU = encryptionData.get("U");
        subV = encryptionData.get("V");
        subW = encryptionData.get("W");
        subX = encryptionData.get("X");
        subY = encryptionData.get("Y");
        subZ = encryptionData.get("Z");
        One = encryptionData.get("~");
        Two = encryptionData.get("^");
        Three = encryptionData.get("[");
        Four = encryptionData.get("#");
        Five = encryptionData.get("@");
        Six = encryptionData.get("*");
        Seven = encryptionData.get("%");
        Eight = encryptionData.get("{");
        Nine = encryptionData.get(":");
        Ten = encryptionData.get("}");
        Eleven = encryptionData.get("<");
        Twelve = encryptionData.get(">");
        Thirteen = encryptionData.get("|");
        Fourteen = encryptionData.get("\\");
        Fifteen = encryptionData.get("_");
        Sixteen = encryptionData.get("]");
        Seventeen = encryptionData.get("$");
        Eighteen = encryptionData.get(";");
        Nineteen = encryptionData.get("!");
        Twenty = encryptionData.get("=");
        Twentyone = encryptionData.get("+");
        Twentytwo = encryptionData.get("-");
        Twentythree = encryptionData.get("1");
        Twentyfour = encryptionData.get("2");
        Twentyfive = encryptionData.get("3");
        Twentysix = encryptionData.get("4");
        Twentyseven = encryptionData.get("5");
        Twentyeight = encryptionData.get("6");
        Twentynine = encryptionData.get("7");
        Thirty = encryptionData.get("8");
        Thirtyone = encryptionData.get("9");
        Thirtytwo = encryptionData.get("0");
        Thirtythree = encryptionData.get("&");
        Thirtyfour = encryptionData.get(".");
        Thirtyfive = encryptionData.get(",");
        Thirtysix = encryptionData.get("(");
        Thirtyseven = encryptionData.get(")");
        Thirtyeight = encryptionData.get("/");
        Thirtynine = encryptionData.get("\\");
        Forty = encryptionData.get("'");
        Fortyone = encryptionData.get("`");
        Fortytwo = encryptionData.get("?");
        Fortythree = encryptionData.get("¢");
        Fortyfour = encryptionData.get("€");
        Fortyfive = encryptionData.get("¥");
        Fortysix = encryptionData.get("^");
        Fortyseven = encryptionData.get("°");
        Fortyeight = encryptionData.get("§");
        Fortynine = encryptionData.get("∆");
        Fifty = encryptionData.get("Π");
        Fiftyone = encryptionData.get("√");
        Fiftytwo = encryptionData.get("•");
        Fiftythree = encryptionData.get("÷");
        Fiftyfour = encryptionData.get("×");
        Fiftyfive = encryptionData.get("©");
        Fiftysix = encryptionData.get("®");
        Fiftyseven = encryptionData.get("™");
        Fiftyeight = encryptionData.get("✓");
        Fiftynine = encryptionData.get("£");
        Sixty = encryptionData.get(" ");

        if (isValidEncryption(plainText)) {
            for (int x=0; x<plainText.length(); x++) {
                dataStoring.add(String.valueOf(plainText.charAt(x)));
            }
            for (String s : dataStoring) {
                outputEnc = encryptionData.get(s);
                encryptedData.add(outputEnc);
            }
        }
    }
    public static void clearingData() {
        dataStoring.clear();
        encryptedData.clear();
    }
}