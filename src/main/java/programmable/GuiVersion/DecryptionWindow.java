package programmable.GuiVersion;

import Encryption.Execute.ExecuteDecryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static fontLoader.FontLoader.jetBrainsMono;
import static programmable.GuiVersion.EncryptionWindow.plainText;

public class DecryptionWindow extends ExecuteDecryption implements ActionListener {

    JFrame frame;
    JPanel pMidContainer;
    public static JTextArea txtInsideMidContainer;
    JScrollPane scrollDecryptContainer;
    JButton btnValueRef, btnDecryption, btnClearText;
    protected DecryptionWindow() {

        URL imageURL = getClass().getClassLoader().getResource("RenWvr.png");
        ImageIcon frameIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(555, 640, Image.SCALE_AREA_AVERAGING));

        txtInsideMidContainer = new JTextArea();
        txtInsideMidContainer.setLineWrap(true);
        txtInsideMidContainer.setWrapStyleWord(true);
        txtInsideMidContainer.setFont(jetBrainsMono.deriveFont(12f));
        txtInsideMidContainer.setEditable(false);
        txtInsideMidContainer.setBackground(new Color(20,20,20));

        scrollDecryptContainer = new JScrollPane(
                txtInsideMidContainer,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pMidContainer = new JPanel();
        pMidContainer.setLayout(new BorderLayout());
        pMidContainer.setBackground(new Color(20,20,20));
        pMidContainer.setBounds(10,10,485, 325);
        pMidContainer.add(scrollDecryptContainer);

        btnValueRef = new JButton("ValueRef");
        btnValueRef.setVisible(true);
        btnValueRef.setBackground(new Color(33,33,33));
        btnValueRef.setFont(jetBrainsMono.deriveFont(12f));
        btnValueRef.setBounds(90, 340, 100,30);
        btnValueRef.addActionListener(this);

        btnDecryption = new JButton("Decrypt");
        btnDecryption.setVisible(true);
        btnDecryption.setBackground(new Color(33,33,33));
        btnDecryption.setFont(jetBrainsMono.deriveFont(12f));
        btnDecryption.setBounds(199, 340, 100,30);
        btnDecryption.addActionListener(this);

        btnClearText = new JButton("clrText");
        btnClearText.setVisible(true);
        btnClearText.setBackground(new Color(33,33,33));
        btnClearText.setFont(jetBrainsMono.deriveFont(12f));
        btnClearText.setBounds(309, 340, 105,30);
        btnClearText.addActionListener(this);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame();
        frame.setSize(520, 650);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(33,33,33));
        frame.setLayout(null);
        frame.setLocation(190, 40);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(33,33,33));
        frame.setIconImage(frameIcon.getImage());

        frame.add(pMidContainer);
        frame.add(btnValueRef);
        frame.add(btnDecryption);
        frame.add(btnClearText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==btnValueRef) {
          txtInsideMidContainer.setText("");
          txtInsideMidContainer.setText(getEncryptedData().toString());
          btnValueRef.setEnabled(false);
       }
       if (e.getSource()==btnDecryption) {
           txtInsideMidContainer.setText("");
           decryptionStart(plainText);
           btnDecryption.setEnabled(false);
           txtInsideMidContainer.setText(String.valueOf(finalOutputData));
       }
       if (e.getSource()==btnClearText) {
           txtInsideMidContainer.setText("");
           btnDecryption.setEnabled(true);
           btnValueRef.setEnabled(true);
           finalOutputData.clear();
       }
    }
}
