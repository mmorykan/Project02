/**
 * Strategy for the warrior person type.
 * The RichieWarrior does a random amount of damage to the enemy in an ugly encounter,
 * and does nothing in a friendly encounter
 *
 * Author: Richie Glennon
 */
package Project02;

import Project02.People;
import Project02.PeopleType;

import java.util.Random;


public class RichieWarrior extends People {
    Random r = new Random();

    /**
     * Create a RichieWarrior object
     * @param nation the nation it belongs to
     * @param tribe the tribe it belongs to
     * @param lifePoints the amount of life points he has
     */
    public RichieWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tRichie Warrior";
    }


    /**
     * Called when otherPerson is from another nation.
     * Randomly does 0 to 100 damage to the other person
     *
     * @param otherPerson the other person encountered
     * @return the amount of damage done
     */
    public int encounterUgly(People otherPerson) {
        return r.nextInt(100);
    }

    /**
     * Called when otherPerson is from the same nation.
     *
     * @param otherPerson the other person encountered
     * @return zero
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
