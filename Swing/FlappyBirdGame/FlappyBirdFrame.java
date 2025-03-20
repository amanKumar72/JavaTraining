package Swing.FlappyBirdGame;

import javax.swing.*;

public class FlappyBirldFrame {
    private JFrame frame=new JFrame("Flappy Bird");
    FlappyBirldFrame(){
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setAutoRequestFocus(true);
        FlappyBirdPanel panel=new FlappyBirdPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.pack();
    }
}
