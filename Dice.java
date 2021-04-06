/**
 * Dice class creates a dice object to use to roll in certain encounters to determine
 * damage. Dice can be created without a parameter at 6 sides or with a parameter.
 * There is a getter and setter for sides and a roll function to roll the dice.
 */
package Project02;

import java.util.Random;

public class Dice {

    private int sides;
    private final Random r = new Random();

    /**
     * Creates Dice object with a number of sides equal to the parameter given
     * @param sideNumber is the number of sides on the dice
     */
    public Dice(int sideNumber) {
        sides = sideNumber;
    }

    /**
     * Creates Dice object with 6 sides if no parameter is given
     */
    public Dice() { this(6); }

    /**
     * Getter for number of sides
     * @return the number of sides to on the dice
     */
    public int getSides() { return sides; }

    /**
     * Setter for number of sides
     * @param sideNumber is the number of sides on the dice
     */
    public void setSides(int sideNumber) {
        this.sides = sideNumber;
    }

    /**
     * Rolls dice. Alters sides if the number of sides on the dice is negative, and
     * returns 0 if the number of sides is 0
     * @return the result of the roll
     */
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
