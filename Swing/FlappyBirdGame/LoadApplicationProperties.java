package Swing.car_game;

import java.util.ResourceBundle;

public class LoadApplicationProperties {
    ResourceBundle resourceBundle;
    public LoadApplicationProperties(){
    resourceBundle=ResourceBundle.getBundle("Swing\\car_game\\application") ;
    }
    public String getWidth(){
        return resourceBundle.getString("WIDTH");
    }
    public String getHight(){
        return resourceBundle.getString("HEIGHT");
    }
    public String getCarHeight(){
        return resourceBundle.getString("CAR_HEIGHT");
    }
    public String getCarWidth(){
        return resourceBundle.getString("CAR_WIDTH");
    }
}
