package databaseRenWvr;

import javax.swing.*;
import java.awt.*;

import static fontLoader.FontLoader.*;

public class Terminal extends JFrame {

    private JLabel title;
    public Terminal() {
        loadFonts();

        title = new JLabel("RenWvr Database");
        title.setBounds(10,0, 500, 100);
        title.setFont(agdasimaRegular.deriveFont(20f));

        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(new Color(0,0,0));
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(0,0,0));

        add(title);
    }

}

