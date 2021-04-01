package Project02;

import java.util.Random;

public class Dice {

    private final int sides;
    private final Random r = new Random();



    public Dice(int sides){ this.sides = sides; }
    public Dice(){ this(6); }

    public int getSides() { return sides; }

    public int roll(){
        return r.nextInt(sides) + 1;
    }
}
