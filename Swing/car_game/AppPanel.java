package Swing.car_game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class AppPanel extends JPanel {
    ImageIcon road;
    BufferedImage car;
    BufferedImage frontCar1;
    BufferedImage frontCar2;
    BufferedImage frontCar3;
    Timer timer;
    boolean isGameOver=false;

    static int score;
    int xAxis=255;
    int yAxis=380;
    int random=-1;
    int[] frontCaraxis={30,180,300,400};
     public int getRandom(){
        int in= (int) Math.floor(Math.random()*4);
        if(in==random){
            in=getRandom();
        }

        return random=in;
    }
    int frontCarYAxis=0,frontCarX1Axis= frontCaraxis[getRandom()],frontCarX2Axis= frontCaraxis[getRandom()],frontCarX3Axis= frontCaraxis[getRandom()];

    AppPanel(){
        setSize(500, 500);
        showBg();
        loopPaint();
        keyboard();
        setFocusable(true);
    }
    void  showBg() {
        try{
            car=ImageIO.read(AppPanel.class.getResource("car.png"));
            road=new ImageIcon(AppPanel.class.getResource("road1gif.gif"));
            frontCar1=ImageIO.read(AppPanel.class.getResource("car.png")) ;
            frontCar2=ImageIO.read(AppPanel.class.getResource("car.png"));
            frontCar3=ImageIO.read(AppPanel.class.getResource("car.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(road.getImage(),20,0,500,500,null);
        g.drawImage(car,xAxis,yAxis,90,140,null);
        g.drawImage(frontCar1,frontCarX1Axis,frontCarYAxis,80,120,null);
        g.drawImage(frontCar2,frontCarX2Axis,frontCarYAxis,80,120,null);
        g.drawImage(frontCar3,frontCarX3Axis,frontCarYAxis,80,120,null);
        if(isGameOver){
            g.setFont(g.getFont().deriveFont(20f));
            g.setColor(Color.cyan);
            g.drawString("Game Over \n Your Score is "+score,100,250);
        }

    }
    void loopPaint() {
        timer = new Timer(25, (a) -> {
            if(carsAreColliding(xAxis, yAxis, frontCarYAxis, frontCarX1Axis)||carsAreColliding(xAxis, yAxis, frontCarYAxis, frontCarX2Axis)||carsAreColliding(xAxis, yAxis, frontCarYAxis, frontCarX3Axis)){
                timer.stop();
                isGameOver=true;
            }
            if(frontCarYAxis>400){
                frontCarYAxis=0;
                frontCarX1Axis=frontCaraxis[getRandom()];
                frontCarX2Axis= frontCaraxis[getRandom()];
                frontCarX3Axis= frontCaraxis[getRandom()];
                score++;
            }else{
                frontCarYAxis+=5;
            }
            repaint();
        });
        timer.start();
    }
    public void keyboard() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(isGameOver){
                    return;
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        if( xAxis<400){
                            xAxis += 10;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if(xAxis>90){
                            xAxis -= 10;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if(yAxis>0){
                            yAxis -= 10;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(yAxis<400){
                            yAxis += 10;
                        }
                        break;
                }
                repaint();
                // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                xAxis+=0;
                // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }

        });
    }

    public boolean carsAreColliding(int xAxis, int yAxis, int frontCarYAxis, int frontCarXAxis) {
        int carWidth = 50;  // Width of the cars
        int carHeight = 100; // Height of the cars

        //boundaries for the main car
        int carX1 = xAxis;
        int carX2 = xAxis + carWidth;
        int carY1 = yAxis;
        int carY2 = yAxis + carHeight;

        int frontCarX1 = frontCarXAxis;
        int frontCarX2 = frontCarXAxis + carWidth;
        int frontCarY1 = frontCarYAxis;
        int frontCarY2 = frontCarYAxis + carHeight;
        if (carX1 < frontCarX2 && carX2 > frontCarX1 && carY1 < frontCarY2 && carY2 > frontCarY1) {
            return true;  // Collision  found
        }

        return false;  // No collision found
    }
}