package Project02;

import java.util.Random;

public class Dice {

    private int sides;
    private final Random r = new Random();

    public Dice(int sideNumber) {
        sides = sideNumber;
    }

    public Dice() { this(6); }

    public int getSides() { return sides; }

    public void setSides(int sideNumber) {
        this.sides = sideNumber;
    }

    public int roll() {
        if (sides < 0) {
            sides = -sides;
            return -r.nextInt(sides) + 1;
        }
        else if (sides == 0)
            return 0;
        return r.nextInt(sides) + 1;
    }
}
