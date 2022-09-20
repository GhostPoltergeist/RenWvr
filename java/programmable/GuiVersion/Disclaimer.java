package programmable.GuiVersion;

import Encryption.Interfaces.LoadingProgress;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disclaimer extends JFrame implements ActionListener, LoadingProgress {
    static int startingPoint;

    JFrame frame;
    JLabel renTitle, addInfo, disclaimer;
    JTextArea information;
    JProgressBar loadingBar;
    public Disclaimer() {
        String defaultFont = "JetBrains Mono";

        renTitle = new JLabel("RenWvr");
        renTitle.setFont(new Font(defaultFont, Font.BOLD, 13));
        renTitle.setBounds(20, 5, 80, 40);

        addInfo = new JLabel("v2.1.1");
        addInfo.setFont(new Font(defaultFont, Font.BOLD, 10));
        addInfo.setBounds(20, 20, 100, 40);

        disclaimer = new JLabel("Disclaimer For DevTeam");
        disclaimer.setFont(new Font(defaultFont, Font.BOLD, 15));
        disclaimer.setBounds(20, 55, 250, 50);

        information = new JTextArea();
        information.setFocusable(false);
        information.setEditable(false);
        information.setBounds(30, 93, 351, 350);
        information.setFont(new Font(defaultFont, Font.PLAIN, 10));
        information.append("""
                        All the information on this website
                        (https://ghostpoltergeist.github.io/RenWvr/)

                        is published in good faith and for general information\s
                        purposes only. RenWvr Program does not make
                        any warranties about the completeness, reliability and
                        accuracy of this information. Any action you take upon\s
                        the information you find on this program\s
                        (RenWvr Program), is strictly at your own risk.\s
                        RenWvr Documentation will not be liable for any losses\s
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
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocation(495, 118);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));


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

        /*while (startingPoint <= 100) {
            loadingBar.setValue(startingPoint);
            sleepWait();
            startingPoint += 5;
        }*/
        try {UIManager.setLookAndFeel(new FlatDarkLaf());
            frame.dispose();
            new WindowsofChoice();
        }
        catch (UnsupportedLookAndFeelException e) {throw new RuntimeException(e);}
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
