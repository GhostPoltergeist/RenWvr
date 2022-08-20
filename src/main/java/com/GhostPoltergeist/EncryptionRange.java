package com.GhostPoltergeist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EncryptionRange {
    static int outputEnc;
    private static int subA, subB, subC, subD, subE, subF, subG, subH, subI,
     subJ, subK, subL, subM, subN, subO, subP, subQ, subR,
     subS, subT, subU, subV, subW, subX, subY, subZ;
    static BufferedReader readingData = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> encryptionData = new HashMap<>();
    static String[] alphabetsData =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z"};
    //----
    static List<String> dataStoring = new ArrayList<>();
    //----
    String plainText;
    int digitNumber;

    public EncryptionRange(String plainText, int digitNumber) throws IOException {
        this.plainText = plainText;
        this.digitNumber = digitNumber;
          if (digitNumber==1)customEncryptionStart(plainText, true);
          else if (digitNumber==2)customEncryptionStart(plainText,false);
          else if (digitNumber==3)customEncryptionStart(plainText,false);
          else if (digitNumber==4)customEncryptionStart(plainText,true);
    }
    private static void customEncryptionStart(String plainText, boolean levelOne) throws IOException {
       if (levelOne) {
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

               System.out.print("\n[x]KeyPairs\n");
               System.out.println(encryptionData.toString() + "\n");

               System.out.println("\n");
               System.out.println("[KeysEmbedded](status){Encrypted!}");

               for (String s : dataStoring) {
                   outputEnc = encryptionData.get(s);
                   System.out.print(outputEnc);
               }
               System.out.println("\n");
               System.out.print("Decrypt Data[y/n]: ");
                String answer = readingData.readLine();
                if (answer.equals("y") || answer.equals("Y")) {
                    proceedDecryption(plainText);
                } else if (answer.equals("n") || answer.equals("N")) {
                    System.exit(0);
                }
           }
       }
    }
    private static boolean isValidEncryption(String plainText) {
        for (int x=0; x<plainText.length(); x++) {
            char reCheck = plainText.charAt(x);

            if (Character.isLowerCase(reCheck)) {
                throw new IllegalEncryptionCharacterException("Read The guideLines properly and Try Again. Something went wrong on the data process",
                new IllegalArgumentException());
            }
        }
        for(int i = 0; i<plainText.length(); i++) {
            char c = plainText.charAt(i);

            if(c == '~' || c == '^' || c == '*' ||
               c == '[' || c == '~' || c == '#' || c == '@' ||
               c == '*' || c == '+' || c == '%' || c == '{' ||
               c == '}' || c == '<' || c == '>' || c == ']' ||
               c == '|' || c == '\\'|| c == '_' || c == ']' ||
               c == '*' || c == '$' || c == ':' || c == ';' ||
               c == '!' || c == '=' || c == '+' || c == '-' ||
               c == ':')  {
                throw new IllegalEncryptionCharacterException("The Message you've pass, returns IllegalCharacters. TRY-AGAIN",
                new IllegalArgumentException());}
        }
        return true;
    }
    public static void proceedDecryption(String plainText) {
        List<Integer> holdTheKey = new ArrayList<>();
        List<String> holdTheInitials = new ArrayList<>();
        Map<Integer, String> keyManipulation = new HashMap<>();
        Map<String, Integer> keyManipulationFirst = new HashMap<>();

        int[] dataPassing = {subA, subB, subC, subD, subE, subF, subG, subH, subI,
                subJ, subK, subL, subM, subN, subO, subP, subQ, subR,
                subS, subT, subU, subV, subW, subX, subY, subZ};

        for (int x=0; x<26; x++) {holdTheKey.add(dataPassing[x]);}

        String[] value = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z"};

       for(int j=0; j<26; j++) {keyManipulation.put(dataPassing[j], value[j]);}

       System.out.print("{RetrieveUnsortedKeys}" + keyManipulation + "[Success]");
       System.out.println("\n");

       for (int j=0; j<26; j++) {keyManipulationFirst.put(value[j], dataPassing[j]);}
       for (int k=0; k<plainText.length(); k++) {holdTheInitials.add(String.valueOf(plainText.charAt(k)));}

       System.out.println("\n(PreparingForManualAdding){RestoringKeys}");
       System.out.println("DecryptedText[From{Variables}]-[To{PlainText}]");

       for(int i=0; i<plainText.length(); i++)
       {System.out.print(keyManipulation.get(keyManipulationFirst.get(holdTheInitials.get(i))));}

        try {Thread.sleep(8000);}
        catch (InterruptedException e) {throw new RuntimeException(e);}

        System.exit(0);
    }
}