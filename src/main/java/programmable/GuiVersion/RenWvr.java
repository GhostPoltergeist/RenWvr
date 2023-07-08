package programmable.GuiVersion;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static databaseRenWvr.DatabaseManager.load;

public class RenWvr {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            Disclaimer disclaimer = new Disclaimer();
        } catch (UnsupportedLookAndFeelException e) {throw new RuntimeException(e);}
    }
}