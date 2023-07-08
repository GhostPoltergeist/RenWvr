package programmable.GuiVersion;

import Encryption.Interfaces.SleepWaiting;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static fontLoader.FontLoader.jetBrainsMono;

public class ManualDecryption implements ActionListener, SleepWaiting {
    //WORKING ON PHASE 1
    public static ArrayList<Integer> dataFinalize = new ArrayList<>();
    public static int linesOfData;
    public static List<String> decryptedData = new ArrayList<>();
    public static int A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    public static String[] numeric = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24", "25", "26"};

    public static String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z", "~", "^", "[", "#",
            "@", "*", "%", "{", ":", "}", "<", ">", "|", "\\",
            "_", "]", "$", ";", "!", "=", "+", "-", "1", "2",
            "3", "4", "5", "6", "7", "8", "9", "0", "&", ".",
            ",", "(", ")"};
    public static HashMap<Integer, String> mappingManuals = new HashMap<>();
    JFrame frame;
    JPanel ptxtFieldHolder;
    JTextField[] txtFieldsArray = new JTextField[26];
    JButton btnDataGathering;
    JProgressBar loadingBar;

    //WORKING ON PHASE 2
    JLabel lbEncryptionLabel;
    JTextArea decryptionConsolePhase;
    JLabel[] ASCII_CODE = new JLabel[7];
    JTextField txtFieldManageLines;
    JScrollPane scrollPaneDataInput;
    static JTextField txtDataSubmitLines;
    JButton btnSubmitData, btnExecuteDecryption, btnSubmitDecryptedData, btnDoneAddingData;
    JProgressBar progSubmittingData;

    //DECRYPTION FINALIZING
    private static int numberChrCntr;
    private static LinkedList<Integer> valueReference = new LinkedList<>();
    ManualDecryption() throws UnsupportedLookAndFeelException {
        URL imageURL = getClass().getClassLoader().getResource("RenWvr.png");
        ImageIcon frameIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(555, 640, Image.SCALE_AREA_AVERAGING));

        for (int x=0; x<txtFieldsArray.length; x++) {
            txtFieldsArray[x] = new JTextField();
            txtFieldsArray[x].setFont(new Font("JetBrains Mono", Font.BOLD, 12));
            txtFieldsArray[x].setBackground(new Color(20,20,20));
        }

        ptxtFieldHolder = new JPanel();
        ptxtFieldHolder.setLayout(new GridLayout(13, 2, 20, 20));
        ptxtFieldHolder.setSize(400, 550);
        ptxtFieldHolder.setBackground(new Color(20,20,20));
        ptxtFieldHolder.setFont(jetBrainsMono.deriveFont(12f));
        ptxtFieldHolder.setLocation(20, 40);

        txtFieldsArray[0].setText("For A");
        ptxtFieldHolder.add(txtFieldsArray[0]);
        txtFieldsArray[1].setText("For B");
        ptxtFieldHolder.add(txtFieldsArray[1]);
        txtFieldsArray[2].setText("For C");
        ptxtFieldHolder.add(txtFieldsArray[2]);
        txtFieldsArray[3].setText("For D");
        ptxtFieldHolder.add(txtFieldsArray[3]);
        txtFieldsArray[4].setText("For E");
        ptxtFieldHolder.add(txtFieldsArray[4]);
        txtFieldsArray[5].setText("For F");
        ptxtFieldHolder.add(txtFieldsArray[5]);
        txtFieldsArray[6].setText("For G");
        ptxtFieldHolder.add(txtFieldsArray[6]);
        txtFieldsArray[7].setText("For H");
        ptxtFieldHolder.add(txtFieldsArray[7]);
        txtFieldsArray[8].setText("For I");
        ptxtFieldHolder.add(txtFieldsArray[8]);
        txtFieldsArray[9].setText("For J");
        ptxtFieldHolder.add(txtFieldsArray[9]);
        txtFieldsArray[10].setText("For K");
        ptxtFieldHolder.add(txtFieldsArray[10]);
        txtFieldsArray[11].setText("For L");
        ptxtFieldHolder.add(txtFieldsArray[11]);
        txtFieldsArray[12].setText("For M");
        ptxtFieldHolder.add(txtFieldsArray[12]);
        txtFieldsArray[13].setText("For N");
        ptxtFieldHolder.add(txtFieldsArray[13]);
        txtFieldsArray[14].setText("For O");
        ptxtFieldHolder.add(txtFieldsArray[14]);
        txtFieldsArray[15].setText("For P");
        ptxtFieldHolder.add(txtFieldsArray[15]);
        txtFieldsArray[16].setText("For Q");
        ptxtFieldHolder.add(txtFieldsArray[16]);
        txtFieldsArray[17].setText("For R");
        ptxtFieldHolder.add(txtFieldsArray[17]);
        txtFieldsArray[18].setText("For S");
        ptxtFieldHolder.add(txtFieldsArray[18]);
        txtFieldsArray[19].setText("For T");
        ptxtFieldHolder.add(txtFieldsArray[19]);
        txtFieldsArray[20].setText("For U");
        ptxtFieldHolder.add(txtFieldsArray[20]);
        txtFieldsArray[21].setText("For V");
        ptxtFieldHolder.add(txtFieldsArray[21]);
        txtFieldsArray[22].setText("For W");
        ptxtFieldHolder.add(txtFieldsArray[22]);
        txtFieldsArray[23].setText("For X");
        ptxtFieldHolder.add(txtFieldsArray[23]);
        txtFieldsArray[24].setText("For Y");
        ptxtFieldHolder.add(txtFieldsArray[24]);
        txtFieldsArray[25].setText("For Z");
        ptxtFieldHolder.add(txtFieldsArray[25]);

        btnDataGathering = new JButton("Pass Data");
        btnDataGathering.setFont(jetBrainsMono.deriveFont(12f));
        btnDataGathering.setFocusable(false);
        btnDataGathering.setEnabled(true);
        btnDataGathering.setBackground(new Color(20,20,20));
        btnDataGathering.setBounds(20, 600, 120, 20);
        btnDataGathering.addActionListener(this);

        loadingBar = new JProgressBar();
        loadingBar.setBounds(450, 30, 250, 5);
        loadingBar.setBackground(new Color(20,20,20,20));
        loadingBar.setStringPainted(true);
        loadingBar.setString("");
        loadingBar.setForeground(Color.GREEN);
        loadingBar.setValue(0);

        lbEncryptionLabel = new JLabel("[Manual Decryption (Enabled)]");
        lbEncryptionLabel.setBounds(450, 50, 220, 15);
        lbEncryptionLabel.setFont(jetBrainsMono.deriveFont(10f));
        lbEncryptionLabel.setForeground(Color.WHITE);
        lbEncryptionLabel.setVisible(true);

        for (int x=0; x< ASCII_CODE.length; x++) {
            ASCII_CODE[x] = new JLabel();
            ASCII_CODE[x].setFont(jetBrainsMono.deriveFont(10f));
            ASCII_CODE[x].setForeground(Color.WHITE);
            ASCII_CODE[x].setVisible(true);
        }

        ASCII_CODE[0].setText("└");
        ASCII_CODE[0].setBounds(460, 80, 220, 15);

        ASCII_CODE[2].setText("┌");
        ASCII_CODE[2].setBounds(630, 72, 220, 20);

        ASCII_CODE[1].setText("┤");
        ASCII_CODE[1].setBounds(630, 88, 220, 20);

        ASCII_CODE[3].setText("└");
        ASCII_CODE[3].setBounds(630, 104, 220, 20);

        ASCII_CODE[4].setText("┌");
        ASCII_CODE[4].setVisible(false);
        ASCII_CODE[4].setBounds(695, 50, 220, 20);

        ASCII_CODE[5].setText("─");
        ASCII_CODE[5].setVisible(false);
        ASCII_CODE[5].setBounds(860, 46, 220, 20)   ;

        ASCII_CODE[6].setText("│");
        ASCII_CODE[6].setVisible(false);
        ASCII_CODE[6].setBounds(898, 66, 220, 20);

        btnExecuteDecryption = new JButton("Exec");
        btnExecuteDecryption.setBounds(641, 104, 60, 20);
        btnExecuteDecryption.setBackground(new Color(20,20,20));
        btnExecuteDecryption.setFont(jetBrainsMono.deriveFont(10f));
        btnExecuteDecryption.setEnabled(false);
        btnExecuteDecryption.addActionListener(this);

        txtFieldManageLines = new JTextField("No. of ChrCntr");
        txtFieldManageLines.setBounds(475, 85, 150, 25);
        txtFieldManageLines.setBackground(new Color(20,20,20));
        txtFieldManageLines.setFont(jetBrainsMono.deriveFont(10f));
        txtFieldManageLines.setVisible(true);

        btnSubmitData = new JButton("Init");
        btnSubmitData.setBounds(641, 72, 60, 20);
        btnSubmitData.setBackground(new Color(20,20,20));
        btnSubmitData.setFont(jetBrainsMono.deriveFont(10f));
        btnSubmitData.addActionListener(this);

        txtDataSubmitLines = new JTextField("Input Every Data");
        txtDataSubmitLines.setBounds(707, 45, 150, 25);
        txtDataSubmitLines.setBackground(new Color(20,20,20));
        txtDataSubmitLines.setFont(jetBrainsMono.deriveFont(10f));
        txtDataSubmitLines.setVisible(false);

        btnSubmitDecryptedData = new JButton("Store");
        btnSubmitDecryptedData.setBounds(872, 46, 60, 20);
        btnSubmitDecryptedData.setBackground(new Color(20,20,20));
        btnSubmitDecryptedData.setFont(jetBrainsMono.deriveFont(10f));
        btnSubmitDecryptedData.setVisible(false);
        btnSubmitDecryptedData.addActionListener(this);

        btnDoneAddingData = new JButton("Done");
        btnDoneAddingData.setBounds(872, 85, 60, 20);
        btnDoneAddingData.setBackground(new Color(20,20,20));
        btnDoneAddingData.setFont(jetBrainsMono.deriveFont(10f));
        btnDoneAddingData.setVisible(false);
        btnDoneAddingData.addActionListener(this);

        decryptionConsolePhase = new JTextArea();
        decryptionConsolePhase.setFont(jetBrainsMono.deriveFont(14f));
        decryptionConsolePhase.setLineWrap(true);
        decryptionConsolePhase.setWrapStyleWord(true);
        decryptionConsolePhase.setForeground(Color.WHITE);
        decryptionConsolePhase.setBackground(new Color(20,20,20));
        decryptionConsolePhase.setBounds(660, 130, 500, 500);

        scrollPaneDataInput = new JScrollPane(decryptionConsolePhase, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDataInput.setBounds(460,150,500, 430);

        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(new Color(20,20,20));
        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(20,20,20));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(993, 670);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(frameIcon.getImage());

        //PHASE 1
        frame.add(ptxtFieldHolder);
        frame.add(btnDataGathering);
        frame.add(loadingBar);

        //PHASE 2
        frame.add(lbEncryptionLabel);

        frame.add(ASCII_CODE[0]);
        frame.add(ASCII_CODE[1]);
        frame.add(ASCII_CODE[2]);
        frame.add(ASCII_CODE[3]);
        frame.add(ASCII_CODE[4]);
        frame.add(ASCII_CODE[5]);
        frame.add(ASCII_CODE[6]);

        frame.add(btnSubmitData);
        frame.add(btnExecuteDecryption);
        frame.add(btnSubmitDecryptedData);
        frame.add(btnDoneAddingData);

        frame.add(txtFieldManageLines);
        frame.add(txtDataSubmitLines);

        frame.add(scrollPaneDataInput);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnDataGathering) {
            int startingPoint = 0;

            while (startingPoint <= 100) {
                loadingBar.setVisible(true);
                while (startingPoint <= 100) {
                    sleepWait();
                    loadingBar.paintImmediately(0, 0, 250, 25);
                    loadingBar.setValue(startingPoint);
                    startingPoint++;
                }
            }
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("JetBrains Mono", Font.BOLD, 12)));
                UIManager.put("Button.background", new ColorUIResource(77, 77, 77));

                try {
                    for (JTextField jTextField : txtFieldsArray) {
                        dataFinalize.add(Integer.valueOf(jTextField.getText()));
                    }

                    //InsertingValues_In_HashMap
                    for (int i=0; i<alphabets.length; i++) {
                        mappingManuals.put(dataFinalize.get(i), alphabets[i]);
                    }

                    /*lbEncryptionLabel.setVisible(true);*/

                } catch (NumberFormatException nfe) {
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setFont(jetBrainsMono.deriveFont(12f));
                    optionPane.setMessage("Data You've Submit is Invalid \nThe Data Must be Integer \nNot A Character");
                    optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                    optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                    recursiveUnfocusButtons(optionPane);
                    JDialog dialog = optionPane.createDialog(null, "");
                    dialog.setVisible(true);
                    dialog.setAlwaysOnTop(true);

                    loadingBar.setValue(0);
                    dataFinalize.clear();
                }
        }
    if (e.getSource()==btnSubmitData) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("JetBrains Mono", Font.BOLD, 12)));
        UIManager.put("Button.background", new ColorUIResource(77, 77, 77));

        try {
                numberChrCntr = Integer.parseInt(txtFieldManageLines.getText());

                ASCII_CODE[4].setVisible(true);
                txtDataSubmitLines.setVisible(true);
                ASCII_CODE[5].setVisible(true);
                btnSubmitDecryptedData.setVisible(true);
                ASCII_CODE[6].setVisible(true);
                btnDoneAddingData.setVisible(true);

            } catch (NumberFormatException nfe) {
                JOptionPane optionPaneBtn = new JOptionPane();
                optionPaneBtn.setFont(jetBrainsMono.deriveFont(12f));
                optionPaneBtn.setMessage("Data You've Submit is Invalid \nThe Data Must be Integer \nNot A Character");
                optionPaneBtn.setMessageType(JOptionPane.ERROR_MESSAGE);
                optionPaneBtn.setOptionType(JOptionPane.DEFAULT_OPTION);
                recursiveUnfocusButtons(optionPaneBtn);
                JDialog dialogTwo = optionPaneBtn.createDialog(null, "");
                dialogTwo.setVisible(true);
            }
        }
    if (e.getSource()==btnSubmitDecryptedData) {
        try {
            valueReference.add(Integer.parseInt(txtDataSubmitLines.getText()));
         
          if (valueReference.size() != numberChrCntr) {
             decryptionConsolePhase.setText(String.valueOf(new IllegalThreadStateException() + " Data Inconsistency Error \nData Must be Equal to the Value of ChrCntr PlaceHolder"));
             btnDoneAddingData.setEnabled(false);
          } else if (valueReference.size() == numberChrCntr) {
              decryptionConsolePhase.setText("");
              btnDoneAddingData.setEnabled(true);
          }
          
        } catch (NumberFormatException nfe) {
            JOptionPane optionPaneBtnThree = new JOptionPane();
            optionPaneBtnThree.setFont(jetBrainsMono.deriveFont(12f));
            optionPaneBtnThree.setMessage("Data You've Submit is Invalid \nThe Data Must be Integer \nNot A Character");
            optionPaneBtnThree.setMessageType(JOptionPane.ERROR_MESSAGE);
            optionPaneBtnThree.setOptionType(JOptionPane.DEFAULT_OPTION);
            recursiveUnfocusButtons(optionPaneBtnThree);
            JDialog dialogThree = optionPaneBtnThree.createDialog(null, "");
            dialogThree.setVisible(true);
        }
        }

     if (e.getSource()==btnDoneAddingData) {
         btnExecuteDecryption.setEnabled(true);
     }

     if (e.getSource()==btnExecuteDecryption) {
         for (Integer integer : valueReference) {
             decryptedData.add(mappingManuals.get(integer));
         }

         decryptionConsolePhase.setText(decryptedData.toString());
     }
    }
    private static void recursiveUnfocusButtons(Component component) {
        if (component instanceof JButton) {
            component.setFocusable(false);
            component.setFont(jetBrainsMono.deriveFont(12f));
            return;
        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                recursiveUnfocusButtons(c);
            }
        }
    }
}

