package Swing.car_game;

public class Car {
    int[] frontCaraxis={30,180,300,400};
    public int getRandom(){
        int in= (int) Math.floor(Math.random()*4);

        return in;
    }
}
