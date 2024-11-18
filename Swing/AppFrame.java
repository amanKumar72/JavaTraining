package Swing;
import javax.swing.JFrame;

public class AppFrame  extends JFrame {
    public AppFrame() {
        init();
    }
    private void init() {
        setSize(570, 570);
        setTitle("My Application");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);//start the img from center
        // setResizable(false);
        setAutoRequestFocus(true);
        AppPanel ap=new AppPanel();
        add(ap);


        setVisible(true);

    }
    
}
