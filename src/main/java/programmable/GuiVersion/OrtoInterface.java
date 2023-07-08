package programmable.GuiVersion;

import com.ortoSpeak.AudioPlayer;
import com.ortoSpeak.UI.WavingLineGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class OrtoInterface extends JFrame {
    JLabel labelPrt;
    public OrtoInterface() throws IOException, FontFormatException, InterruptedException {
        new WavingLineGUI();
    }
}
