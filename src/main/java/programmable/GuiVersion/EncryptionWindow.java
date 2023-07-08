package programmable.GuiVersion;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import Encryption.Execute.ExecuteEncryption;
import Encryption.Interfaces.SleepWaiting;
import Exceptions.Calling.IllegalCharacters.IllegalCharacterException;
import com.ortoSpeak.AudioPlayer;
import databaseRenWvr.Terminal;
import databaseRenWvr.Transition.MovingFrame;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static Encryption.Execute.ExecuteDecryption.clearData;
import static fontLoader.FontLoader.jetBrainsMono;

public class EncryptionWindow extends ExecuteEncryption implements ActionListener, SleepWaiting {
    private int startX;
    private int endX;
    private int duration = 1000; // Duration in milliseconds
    private Timer timer;
    public boolean isTaskRunning;
    URL imageURL = getClass().getClassLoader().getResource("RenWvr.png");
    ImageIcon frameIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(555, 640, Image.SCALE_AREA_AVERAGING));
    public static List<Integer> exportingDataHolder = new ArrayList<>();
    static int startingPoint = 0;
    public static volatile String plainText = "";
    JFrame frame;
    JLabel lMidTitle, lbottomCharCounter, lIsValidEncryption;
    JScrollPane scrollPane, scrollPaneDataInput;
    JPanel pMidContainerHolder, pLowContainerHandler;
    JTextArea txtAreaDataInput;
    JTextArea txtAreaExceptionThrows;
    JProgressBar progEncryptBar;
    JButton btnEncrypt, btnDecrypt, btnDecryptVR, btnImportDecrypt, btnExportData, btnClearData, btnquestionmark, btnDatabase;
    protected EncryptionWindow() throws IOException, FontFormatException {
        lMidTitle = new JLabel("Data Mixing");
        lMidTitle.setForeground(Color.WHITE);
        lMidTitle.setBounds(10,0, 120, 30);
        lMidTitle.setFont(jetBrainsMono.deriveFont(12f));

        lbottomCharCounter = new JLabel("ChrCntr: ");
        lbottomCharCounter.setForeground(Color.GREEN);
        lbottomCharCounter.setBounds(10,540, 100, 30);
        lbottomCharCounter.setFont(jetBrainsMono.deriveFont(9f));
        
        lIsValidEncryption = new JLabel("isValid: [default]");
        lIsValidEncryption.setForeground(Color.GREEN);
        lIsValidEncryption.setBounds(10,560, 130, 30);
        lIsValidEncryption.setFont(jetBrainsMono.deriveFont(9f));

        txtAreaDataInput = new JTextArea();
        txtAreaDataInput.setFont(jetBrainsMono.deriveFont(12f));
        txtAreaDataInput.setLineWrap(true);
        txtAreaDataInput.setWrapStyleWord(true);
        txtAreaDataInput.setForeground(Color.WHITE);
        txtAreaDataInput.setBackground(Color.BLACK);
        txtAreaDataInput.setBounds(10, 30, 490, 150);

        scrollPaneDataInput = new JScrollPane(txtAreaDataInput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDataInput.setBounds(10,30,486, 150);

        pMidContainerHolder = new JPanel();
        pMidContainerHolder.setLayout(null);
        pMidContainerHolder.setBounds(0, 0, 520, 250);
        pMidContainerHolder.setBackground(new Color(20,20,20));
        pMidContainerHolder.add(lMidTitle);
        pMidContainerHolder.add(scrollPaneDataInput);

        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.setVisible(true);
        btnEncrypt.setFocusable(false);
        btnEncrypt.setFont(jetBrainsMono.deriveFont(12f));
        btnEncrypt.setBackground(new Color(33,33,33));
        btnEncrypt.setBounds(10, 260, 100, 30);
        btnEncrypt.addActionListener(this);

        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.setVisible(true);
        btnDecrypt.setFocusable(false);
        btnDecrypt.setFont(jetBrainsMono.deriveFont(12f));
        btnDecrypt.setBackground(new Color(33,33,33));
        btnDecrypt.setBounds(10, 310, 100, 30);
        btnDecrypt.addActionListener(this);

        btnDecryptVR = new JButton("DecryptVR");
        btnDecryptVR.setVisible(true);
        btnDecryptVR.setFocusable(false);
        btnDecryptVR.setFont(jetBrainsMono.deriveFont(12f));
        btnDecryptVR.setBackground(new Color(33,33,33));
        btnDecryptVR.setBounds(10, 360, 100, 30);
        btnDecryptVR.addActionListener(this);

        btnImportDecrypt = new JButton("Import");
        btnImportDecrypt.setVisible(true);
        btnImportDecrypt.setFocusable(false);
        btnImportDecrypt.setFont(jetBrainsMono.deriveFont(12f));
        btnImportDecrypt.setBackground(new Color(33,33,33));
        btnImportDecrypt.setBounds(10, 410, 100, 30);
        btnImportDecrypt.addActionListener(this);

        btnExportData = new JButton("Export");
        btnExportData.setVisible(true);
        btnExportData.setFocusable(false);
        btnExportData.setFont(jetBrainsMono.deriveFont(12f));
        btnExportData.setBackground(new Color(33,33,33));
        btnExportData.setBounds(10, 460, 100, 30);
        btnExportData.addActionListener(this);
        btnExportData.setEnabled(false);
        
        btnClearData = new JButton("clrData");
        btnClearData.setEnabled(false);
        btnClearData.setVisible(true);
        btnClearData.setFocusable(false);
        btnClearData.setFont(jetBrainsMono.deriveFont(12f));
        btnClearData.setBackground(new Color(33,33,33));
        btnClearData.setBounds(10, 510, 100, 30);
        btnClearData.addActionListener(this);

        btnquestionmark = new JButton("?");
        btnquestionmark.setEnabled(true);
        btnquestionmark.setVisible(true);
        btnquestionmark.setFocusable(false);
        btnquestionmark.setFont(jetBrainsMono.deriveFont(12f));
        btnquestionmark.setBackground(new Color(33,33,33));
        btnquestionmark.setBounds(480, 570, 20, 30);
        btnquestionmark.addActionListener(this);

        btnDatabase = new JButton("DB");
        btnDatabase.setEnabled(true);
        btnDatabase.setVisible(true);
        btnDatabase.setFocusable(false);
        btnDatabase.setFont(jetBrainsMono.deriveFont(10f));
        btnDatabase.setBackground(new Color(33,33,33));
        btnDatabase.setBounds(10, 585, 45, 20);
        btnDatabase.addActionListener(this);
        
        txtAreaExceptionThrows = new JTextArea();
        txtAreaExceptionThrows.setFocusable(false);
        txtAreaExceptionThrows.setFont(jetBrainsMono.deriveFont(12f));
        txtAreaExceptionThrows.setLineWrap(true);
        txtAreaExceptionThrows.setWrapStyleWord(true);
        txtAreaExceptionThrows.setForeground(Color.WHITE);
        txtAreaExceptionThrows.setBackground(new Color(33,33,33));

        scrollPane = new JScrollPane(txtAreaExceptionThrows, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setFocusable(false);

        pLowContainerHandler = new JPanel();
        pLowContainerHandler.setBounds(120, 260, 380, 300);
        pLowContainerHandler.setBackground(new Color(20,20,20));
        pLowContainerHandler.setFont(jetBrainsMono.deriveFont(10f));
        pLowContainerHandler.setLayout(new BorderLayout());
        pLowContainerHandler.add(scrollPane);

        progEncryptBar = new JProgressBar();
        progEncryptBar.setBounds(157, 580, 300, 8);
        progEncryptBar.setStringPainted(true);
        progEncryptBar.setString("");
        progEncryptBar.setForeground(Color.GREEN);
        progEncryptBar.setValue(0);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame();
        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(20,20,20));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 650);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(33,33,33));
        frame.setVisible(true);
        frame.setIconImage(frameIcon.getImage());

        frame.add(pMidContainerHolder);
        frame.add(pLowContainerHandler);

        frame.add(btnEncrypt);
        frame.add(btnDecrypt);
        frame.add(btnDecryptVR);
        frame.add(btnImportDecrypt);
        frame.add(btnClearData);
        frame.add(btnExportData);
        frame.add(btnquestionmark);
        frame.add(btnDatabase);

        frame.add(progEncryptBar);

        frame.add(lbottomCharCounter);
        frame.add(lIsValidEncryption);

        AudioPlayer.OrtoProgramming(true, false, false, false, false, false, false);
    }
    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnEncrypt) {
         startingPoint = 0;

         plainText = txtAreaDataInput.getText().toUpperCase(Locale.ROOT);

         while (startingPoint <= 100) {
             progEncryptBar.setVisible(true);
             while (startingPoint <= 100) {
                 sleepWait();

                 if (!plainText.equals("")) {
                     btnClearData.setEnabled(true);
                     btnExportData.setEnabled(true);
                 }

                 progEncryptBar.paintImmediately(0, 0, 300, 25);
                 progEncryptBar.setValue(startingPoint);
                 startingPoint++;
             }
         }
         isValidEncryption(plainText);
         runEncryption(plainText);
         txtAreaExceptionThrows.setText(getEncryptedData().toString());
         lbottomCharCounter.setText("ChrCntr: " + plainText.length());
         lIsValidEncryption.setText("isValid: [true]");
     }
     if (e.getSource()==btnDecrypt) {
         sleepWait();
         new DecryptionWindow();
     }
     if (e.getSource()==btnDecryptVR) {
         sleepWait();
         new ManualDecryption();
     }
     if (e.getSource()==btnClearData) {
         exportingDataHolder.clear();
         btnClearData.setEnabled(false);
         btnExportData.setEnabled(false);
         plainText = "";
         txtAreaExceptionThrows.setText("");
         txtAreaDataInput.setText("");
         lIsValidEncryption.setText("isValid: [default]");
         lbottomCharCounter.setText("ChrCntr: " + plainText.length());
         progEncryptBar.setValue(0);
         clearingData();
         clearData();
     }
     if (e.getSource()==btnImportDecrypt) {
         JFileChooser fileChooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
         fileChooser.setFileFilter(filter);
         int response = fileChooser.showOpenDialog(null);

         if (response == JFileChooser.APPROVE_OPTION) {
             File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                FileReader fileTempPlaceHolder = new FileReader(file);
                BufferedReader buffering = new BufferedReader(fileTempPlaceHolder);

                Object[] lines = buffering.lines().toArray();

                for (Object line : lines) {
                    String row = String.valueOf(line.toString());
                    plainText = row;
                    txtAreaDataInput.setText(plainText);
                }

                fileTempPlaceHolder.close();
                buffering.close();

            } catch (Exception er) {er.printStackTrace();}
         }
     }
        if (e.getSource()==btnExportData) {
            String fileName = "RenWvr_Keys.png";

            int width = 250;
            int height = 250;
            String format = "png";

            //TIME EXECUTED
            LocalTime myObj = LocalTime.now();

            //PLAINTEXT VALUE
            String plainTextValue = plainText;

            //ENCRYPTED DATA READY TO EXPORT
            String encryptedDataValue = getEncryptedData().toString();

            exportingDataHolder.add(subA);
            exportingDataHolder.add(subB);
            exportingDataHolder.add(subC);
            exportingDataHolder.add(subD);
            exportingDataHolder.add(subE);
            exportingDataHolder.add(subF);
            exportingDataHolder.add(subG);
            exportingDataHolder.add(subH);
            exportingDataHolder.add(subI);
            exportingDataHolder.add(subJ);
            exportingDataHolder.add(subK);
            exportingDataHolder.add(subL);
            exportingDataHolder.add(subM);
            exportingDataHolder.add(subN);
            exportingDataHolder.add(subO);
            exportingDataHolder.add(subP);
            exportingDataHolder.add(subQ);
            exportingDataHolder.add(subR);
            exportingDataHolder.add(subS);
            exportingDataHolder.add(subT);
            exportingDataHolder.add(subU);
            exportingDataHolder.add(subV);
            exportingDataHolder.add(subW);
            exportingDataHolder.add(subX);
            exportingDataHolder.add(subY);
            exportingDataHolder.add(subZ);

            try {
                File directoryRenWvr = new File(System.getProperty("user.home") + "\\Desktop\\RenWvr");
                boolean creatingDirectory = directoryRenWvr.mkdirs();

                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\RenWvr\\EncryptedNodes.txt"));
                String textOne = "TimeOfExecution: ";
                writer.write(textOne);
                writer.write(String.valueOf(myObj));
                writer.write("\n");
                writer.write("\n");
                writer.write("\n");

                writer.write("TextInput: ");
                writer.write(plainTextValue);
                writer.write("\n");
                writer.write("\n");

                writer.write("EncryptedText: ");
                writer.write(encryptedDataValue);

                writer.write("\n");
                writer.write("\n");
                writer.write("\n");

                writer.write("[KEEP THIS PRIVATE!]");
                writer.write(" - [EncryptionKeys] - ");
                writer.write("\n");
                writer.write(encryptionData.toString());

                writer.close();

            } catch (Exception er) {er.printStackTrace();}

            try {
                MultiFormatWriter writer = new MultiFormatWriter();
                BitMatrix bitMatrix = writer.encode(encryptedDataValue, BarcodeFormat.QR_CODE, width, height, getQRCodeHints());

                java.awt.image.BufferedImage qrImage = new java.awt.image.BufferedImage(width, height,
                        java.awt.image.BufferedImage.TYPE_INT_RGB);
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                    }
                }

                String resourceFolder = System.getProperty("user.home") + "\\Desktop\\RenWvr\\";

                String destinationPath = resourceFolder + fileName;

                File qrFile = new File(destinationPath);
                ImageIO.write(qrImage, format, qrFile);

            } catch (Exception er) {
                er.printStackTrace();
            }
        }

        if (e.getSource()==btnquestionmark) {
            new OrtoInterface();
        }

        if (e.getSource() == btnDatabase) {
            Thread taskThread;

            this.isTaskRunning = true;
            taskThread = new Thread(() -> {
                MovingFrame movingFrame = new MovingFrame();
                movingFrame.moveFrameSmoothly(frame);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                new Terminal();

                this.isTaskRunning = false;
            });
            taskThread.start();
        }
    }
    @SneakyThrows
    @Override
    public boolean isValidEncryption(String plainText) {
        for (int x = 0; x < plainText.length(); x++) {
            char data = plainText.charAt(x);

            if (Character.isLowerCase(data)) {
                btnClearData.setEnabled(false);
                lIsValidEncryption.setText("isValid: [false]");
                txtAreaExceptionThrows.setText("""
                      Exception in thread "AWT-EventQueue-0" Exceptions.Calling.IllegalCharacters\s
                      IllegalCharacterException: Undefined Data at programmable.GuiVersion.WindowsofChoice\s
                      isValidEncryption at programmable.GuiVersion.WindowsofChoice\s
                      ActionPerformed at java.desktop/javax.swing.plaf.basic.BasicButtonListener.mouseReleased""");
                throw new IllegalCharacterException("Undefined Data");
            }
        }
        return true;
    }
    private static java.util.Map<EncodeHintType, Object> getQRCodeHints() {
        java.util.Map<EncodeHintType, Object> hints = new java.util.HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        return hints;
    }
}

