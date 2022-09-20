package programmable.GuiVersion;

import Encryption.ExecuteEncryption.Execute;
import Encryption.Interfaces.SleepWaiting;
import Exceptions.Calling.IllegalCharacters.IllegalCharacterException;
import Exceptions.Calling.InvalidValueReference.InvalidValueReferenceException;
import Exceptions.Calling.UnsupportedSymbols.SymbolNotSupportedException;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.util.Locale;

public class WindowsofChoice extends Execute implements ActionListener, SleepWaiting {
    static int startingPoint = 0;
    JFrame frame;
    JLabel lMidTitle;
    JScrollPane scrollPane;
    JPanel pMidContainerHolder, pLowContainerHandler;
    JTextArea txtAreaDataInput, txtAreaExceptionThrows;
    JProgressBar progEncryptBar;
    JButton btnEncrypt, btnDecrypt, btnDecryptVR, btnImportDecrypt;
    protected WindowsofChoice() {
        lMidTitle = new JLabel("Data Mixing");
        lMidTitle.setForeground(Color.GREEN);
        lMidTitle.setBounds(10,0, 100, 30);
        lMidTitle.setFont(new Font("JetBrains Mono", Font.BOLD, 12));

        txtAreaDataInput = new JTextArea();
        txtAreaDataInput.setFont(new Font("JetBrains Mono", Font.BOLD, 13));
        txtAreaDataInput.setLineWrap(true);
        txtAreaDataInput.setWrapStyleWord(true);
        txtAreaDataInput.setForeground(Color.GREEN);
        txtAreaDataInput.setBackground(Color.BLACK);
        txtAreaDataInput.setBounds(10, 30, 490, 150);

        pMidContainerHolder = new JPanel();
        pMidContainerHolder.setLayout(null);
        pMidContainerHolder.setBounds(0, 0, 520, 250);
        pMidContainerHolder.setBackground(Color.BLACK);
        pMidContainerHolder.add(lMidTitle);
        pMidContainerHolder.add(txtAreaDataInput);

        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setVisible(true);
        btnEncrypt.setFocusable(false);
        btnEncrypt.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        btnEncrypt.setBackground(new Color(33,33,33));
        btnEncrypt.setBounds(10, 260, 100, 30);
        btnEncrypt.addActionListener(this);

        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.setVisible(true);
        btnDecrypt.setFocusable(false);
        btnDecrypt.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        btnDecrypt.setBackground(new Color(33,33,33));
        btnDecrypt.setBounds(10, 310, 100, 30);

        btnDecryptVR = new JButton("DecryptVR");
        btnDecryptVR.setVisible(true);
        btnDecryptVR.setFocusable(false);
        btnDecryptVR.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        btnDecryptVR.setBackground(new Color(33,33,33));
        btnDecryptVR.setBounds(10, 360, 100, 30);

        btnImportDecrypt = new JButton("Import");
        btnImportDecrypt.setVisible(true);
        btnImportDecrypt.setFocusable(false);
        btnImportDecrypt.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        btnImportDecrypt.setBackground(new Color(33,33,33));
        btnImportDecrypt.setBounds(10, 410, 100, 30);

        txtAreaExceptionThrows = new JTextArea();
        txtAreaExceptionThrows.setFocusable(false);
        txtAreaExceptionThrows.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        txtAreaExceptionThrows.setLineWrap(true);
        txtAreaExceptionThrows.setWrapStyleWord(true);
        txtAreaExceptionThrows.setForeground(Color.WHITE);
        txtAreaExceptionThrows.setBackground(new Color(33,33,33));

        scrollPane = new JScrollPane(txtAreaExceptionThrows, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setFocusable(false);

        pLowContainerHandler = new JPanel();
        pLowContainerHandler.setBounds(120, 260, 380, 300);
        pLowContainerHandler.setBackground(new Color(33,33,33));
        pLowContainerHandler.setFont(new Font("JetBrains Mono", Font.BOLD, 10));
        pLowContainerHandler.setLayout(new BorderLayout());
        pLowContainerHandler.add(scrollPane);

        progEncryptBar = new JProgressBar();
        progEncryptBar.setBounds(98, 580, 300, 8);
        progEncryptBar.setStringPainted(true);
        progEncryptBar.setString("");
        progEncryptBar.setForeground(Color.GREEN);
        progEncryptBar.setValue(0);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame();
        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", Color.BLACK);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 650);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setLocation(390, 40);
        frame.getContentPane().setBackground(new Color(33,33,33));
        frame.setVisible(true);

        frame.add(pMidContainerHolder);
        frame.add(pLowContainerHandler);

        frame.add(btnEncrypt);
        frame.add(btnDecrypt);
        frame.add(btnDecryptVR);
        frame.add(btnImportDecrypt);

        frame.add(progEncryptBar);
    }
    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnEncrypt)
         startingPoint = 0;

         String plainText = txtAreaDataInput.getText().toUpperCase(Locale.ROOT);

         while (startingPoint <= 100) {
             progEncryptBar.setVisible(true);
             while (startingPoint <= 100) {
                 sleepWait();
                 progEncryptBar.paintImmediately(0, 0, 300, 25);
                 progEncryptBar.setValue(startingPoint);
                 startingPoint++;
             }
         }
         isValidEncryption(plainText);
         runEncryption(plainText);
         txtAreaExceptionThrows.setText(getEncryptedData().toString());
    }
    @SneakyThrows
    @Override
    public boolean isValidEncryption(String plainText) {
        for (int x = 0; x < plainText.length(); x++) {
            char data = plainText.charAt(x);

            if (Character.isLowerCase(data)) {
                txtAreaExceptionThrows.setText("""
                      Exception in thread "AWT-EventQueue-0" Exceptions.Calling.IllegalCharacters\s
                      IllegalCharacterException: Undefined Data at programmable.GuiVersion.WindowsofChoice\s
                      isValidEncryption at programmable.GuiVersion.WindowsofChoice\s
                      ActionPerformed at java.desktop/javax.swing.plaf.basic.BasicButtonListener.mouseReleased""");
                throw new IllegalCharacterException("Undefined Data");
            }
            if (data == '1' || data == '2' || data == '3' ||
                    data == '4' || data == '5' || data == '6' ||
                    data == '7' || data == '8' ||
                    data == '9') {
                txtAreaExceptionThrows.setText("""
                                   Exception in Encryption Algorithm :From: \s[InvalidValueReferenceException]
                                   Exceptions.Calling.InvalidValueReference \s[InvalidValueReferenceException]
                                   Exception Occurred: \s[Encryption Must Be PlainText Only (No Numeric Data is Allowed!)]""");
                throw new InvalidValueReferenceException("", new IllegalArgumentException());
            }
            if (data == '~' || data == '^' || data == '[' ||
                    data == '#' || data == '@' || data == '*' ||
                    data == '%' || data == '{' || data == ':' ||
                    data == '}' || data == '<' || data == '>' ||
                    data == '|' || data == '\\'|| data == '_' ||
                    data == ']' || data == '$' || data == ';' ||
                    data == '!' || data == '=' || data == '+' ||
                    data == '-') {

                txtAreaExceptionThrows.setText("""
                                  Exception in Encryption Algorithm :From: \s[SymbolNotSupportedException]
                                  Exceptions.Calling.SymbolNotSupportedException \s[SymbolNotSupportedException]
                                  Exception Occurred: \s[Encryption Must Be PlainText Only (No Symbol Data is Allowed!)]""");
                throw new SymbolNotSupportedException("", new InvalidKeyException());
            }
        }
        return true;
    }
}
