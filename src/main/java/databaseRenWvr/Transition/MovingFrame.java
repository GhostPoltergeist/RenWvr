package databaseRenWvr.Transition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MovingFrame {
    private int startX;
    private int endX;
    private int duration = 1000; // Duration in milliseconds
    private Timer timer;
    
    public void moveFrameSmoothly(JFrame frame) {
        startX = frame.getLocation().x;
        endX = Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth(); // Target position on the right side of the screen

        int totalDistance = endX - startX;
        int distancePerStep = totalDistance / (duration / 10); // Calculate distance to move each timer tick

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.getLocation().x >= endX) {
                    frame.setLocation(endX, frame.getLocation().y);
                    timer.stop();
                } else {
                    frame.setLocation(frame.getLocation().x + distancePerStep, frame.getLocation().y);
                }
            }
        });

        timer.start();
    }
}
