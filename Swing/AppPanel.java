package Swing;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

public class AppPanel extends JPanel {
    BufferedImage bufferImage;
//    ImageIcon bufferImage;
    Timer timer;
    int xAxis = 0;
    int yAxis = 0;

    AppPanel() {
        setSize(500, 500);
//        setBackground(Color.GREEN);
        showBg();
        loopPaint();
        //  keyboard();
        setFocusable(true);
    }


    void showBg() { //load the images and other stuff
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("file.png"));
//            bufferImage = new ImageIcon(AppPanel.class.getResource("file.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) { //paint the component only once
        super.paintComponent(g);    //clear the old graphics
        g.drawImage(bufferImage, xAxis, yAxis, 50, 50, null);//draw thw new graphics on the panel

    }


    int a=0,b=0;
    void loopPaint() { //use for print the graphics after a certain time
        timer = new Timer(50, (e) -> {

            if(b<=480){
                yAxis= yAxis + 12;
                b= b + 12;
            }
            else if(b<=960 ){
                yAxis= yAxis - 12;
                b= b + 12;
            }
            if(a<=500 ){
                xAxis= xAxis + 5;
                a= a + 5;
            }
            else if(a<=1000 ){
                xAxis= xAxis - 5;
                a= a + 5;
            }
            if(a>=1000){
                a=0;
                xAxis=0;
            }
            if(b>=960){
              b=0;
              yAxis=0;
            }

            repaint();//for repaint the graphics
        });
        timer.start();//start the timer
    }




    public void keyboard() {  //control on the keyboard keys
        System.out.println("keyboard called");
        addKeyListener(new KeyListener() {  // listen the key entered by user
            @Override
            public void keyTyped(KeyEvent e) { //called when the key typed
                // TODO Auto-generated method stub
            }

            @Override
            public void keyPressed(KeyEvent e) { //called when the key pressed and get the key in keyEvent z
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        xAxis += 5;
                        break;
                    case KeyEvent.VK_LEFT:
                        xAxis -= 5;
                        break;
                    case KeyEvent.VK_UP:
                        yAxis -= 5;
                        break;
                    case KeyEvent.VK_DOWN:
                        yAxis += 5;
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }
}