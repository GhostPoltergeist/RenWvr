package com.GhostPoltergeist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ManualDec {
    static int A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    static int[] dataFunction = {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};

    static String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                    "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                    "T", "U", "V", "W", "X", "Y", "Z"};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, String> mappingManuals = new HashMap<>();

    public static void decryptPlainText() throws IOException {
        storeValues(mappingManuals);

       if (!isValidDecryption(mappingManuals)) {System.exit(0);}

       else {
           System.out.println("VALID! SUCCESS!");
       }

    }

 private static boolean isValidDecryption(HashMap<Integer, String> mappingManuals) {
     if(mappingManuals == null) {
         return true;
     }

     for (int x=0; x<mappingManuals.size(); x++) {
     }

     return true;
 }
 private static void storeValues(HashMap<Integer, String> mappingManuals) throws IOException {
     System.out.print("A: ");
     A = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("B: ");
     B = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     /*
     System.out.print("C: ");
     C = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("D: ");
     D = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("E: ");
     E = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("F: ");
     F = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("G: ");
     G = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("H: ");
     H = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("I: ");
     I = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("J: ");
     J = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("K: ");
     K = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("L: ");
     L = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("M: ");
     M = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("N: ");
     N = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("O: ");
     O = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("P: ");
     P = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("Q: ");
     Q = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("R: ");
     R = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("S: ");
     S = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("T: ");
     T = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("U: ");
     U = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("V: ");
     V = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("W: ");
     W = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("X: ");
     X = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("Y: ");
     Y = Integer.parseInt(reader.readLine());
     System.out.print("\n");
     System.out.print("Z: ");
     Z = Integer.parseInt(reader.readLine());*/

     for (int j=0; j<26; j++) {mappingManuals.put(dataFunction[j], alphabets[j]);}
 }
}

