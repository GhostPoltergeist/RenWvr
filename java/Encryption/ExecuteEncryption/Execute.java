package Encryption.ExecuteEncryption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Execute extends isValid {


    public static List<Integer> getEncryptedData() {return encryptedData;}
    public static List<Integer> encryptedData = new ArrayList<>();
    public static int outputEnc;

    private static int subA, subB, subC, subD, subE, subF, subG, subH, subI,
            subJ, subK, subL, subM, subN, subO, subP, subQ, subR,
            subS, subT, subU, subV, subW, subX, subY, subZ;
    static HashMap<String, Integer> encryptionData = new HashMap<>();

    static String[] alphabetsData =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
             "K", "L", "M", "N", "O", "P", "Q", "R", "S",
             "T", "U", "V", "W", "X", "Y", "Z"};

    static List<String> dataStoring = new ArrayList<>();

    int digitNumber;

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

        if (isValidEncryption(plainText)) {
            for (int x=0; x<plainText.length(); x++) {
                dataStoring.add(String.valueOf(plainText.charAt(x)));
            }
            for (String s : dataStoring) {
                outputEnc = encryptionData.get(s);
                encryptedData.add(outputEnc);
            }
        }
        if (plainText.equals("CLRD")) {
            encryptedData.clear();
        }
    }
}
