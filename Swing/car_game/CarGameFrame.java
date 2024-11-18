package Swing.car_game;

import javax.swing.JFrame;


public class CarGameFrame {
    private JFrame jFrame=new JFrame();
    CarGameFrame() {
        jFrame.setSize(500, 500);
        jFrame.setTitle("My Application");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);// start the img from center
        // setResizable(false);
        jFrame.setAutoRequestFocus(true);
        Swing.car_game.AppPanel ap = new Swing.car_game.AppPanel();
        jFrame.add(ap);
        jFrame.setVisible(true);
    }
}
