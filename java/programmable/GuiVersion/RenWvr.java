package programmable.GuiVersion;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class RenWvr {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            new Disclaimer();
        } catch (UnsupportedLookAndFeelException e) {throw new RuntimeException(e);}
    }
}