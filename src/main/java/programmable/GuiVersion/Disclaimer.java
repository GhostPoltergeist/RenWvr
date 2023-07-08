package programmable.GuiVersion;

import Encryption.Interfaces.LoadingProgress;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import static fontLoader.FontLoader.jetBrainsMono;
import static fontLoader.FontLoader.loadFonts;

public class Disclaimer extends JFrame implements ActionListener, LoadingProgress {
    URL imageURL = getClass().getClassLoader().getResource("RenWvr.png");
    ImageIcon frameIcon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(555, 640, Image.SCALE_AREA_AVERAGING));
    static int startingPoint;
    JFrame frame;
    JLabel renTitle, addInfo, disclaimer;
    JTextArea information;
    JProgressBar loadingBar;
    public Disclaimer() {
        loadFonts();

        renTitle = new JLabel("RenWvr");
        renTitle.setFont(jetBrainsMono.deriveFont(13f));
        renTitle.setBounds(20, 5, 80, 40);

        addInfo = new JLabel("v2.5.10.12");
        addInfo.setFont(jetBrainsMono.deriveFont(10f));
        addInfo.setBounds(20, 20, 100, 40);

        disclaimer = new JLabel("@GhostPoltergeist 2022");
        disclaimer.setFont(jetBrainsMono.deriveFont(15f));
        disclaimer.setBounds(20, 55, 250, 50);

        information = new JTextArea();
        information.setFocusable(false);
        information.setEditable(false);
        information.setBounds(30, 110, 380, 350);
        information.setWrapStyleWord(true);
        information.setFont(jetBrainsMono.deriveFont(10f));
        information.append("""
                        All the information on this website
                        (https://ghostpoltergeist.github.io/RenWvr/)

                        is published in good faith and for general information\s
                        purposes only. RenWvr Program does not make
                        any warranties about the completeness, reliability and
                        accuracy of this information. Any action you take upon\s
                        the information you find on this program\s
                        (RenWvr Encryption), is strictly at your own risk.\s
                        RenWvr Encryption System will not be liable for any losses\s
                        and/or damages in connection with the use of our website.\s


                        From our website, you can visit other System
                        by following hyperlinks to such external sites.\s
                        While we strive to provide only quality links to
                        useful and ethical websites, we have no control
                        over the content and nature of these programs.\s
                        These links to other websites do not imply
                        A recommendation for all the content found on these sites.
                        Site owners and content may change without notice
                        and may occur before we have the opportunity to remove
                        a link which may have gone 'bad'.
                        """
                );

        loadingBar = new JProgressBar();
        loadingBar.setBounds(30, 460, 350, 10);
        loadingBar.setStringPainted(true);
        loadingBar.setString("");
        loadingBar.setForeground(Color.GREEN);
        loadingBar.setValue(0);

        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(440, 550);
        frame.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        frame.setIconImage(frameIcon.getImage());
        frame.setLocationRelativeTo(null);

        //Labels
        frame.add(renTitle);
        frame.add(addInfo);
        frame.add(disclaimer);

        //TextField
        frame.add(information);

        //Panels


        //ProgressBar
        frame.add(loadingBar);

        //Buttons


        //FillingTheLoadingBarForLoadingScreen
        try {fillingBar();}
        catch (InterruptedException e) {throw new RuntimeException(e);}

    }
    private void fillingBar() throws InterruptedException {
        startingPoint = 0;

       while (startingPoint <= 100) {
           loadingBar.setValue(startingPoint);
           sleepWait();
           startingPoint += 5;
       }
        try {UIManager.setLookAndFeel(new FlatDarkLaf());
            frame.dispose();
            new EncryptionWindow();
        }
        catch (UnsupportedLookAndFeelException | FontFormatException | IOException e) {throw new RuntimeException(e);}
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
