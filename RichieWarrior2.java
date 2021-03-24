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


public class RichieWarrior2 extends People {
    Random r = new Random();

    /**
     * Create a RichieWarrior object
     * @param nation the nation it belongs to
     * @param tribe the tribe it belongs to
     * @param lifePoints the amount of life points he has
     */
    public RichieWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tRichie Warrior2";
    }


    /**
     * Called when otherPerson is from another nation.
     * against a healer does from 40 - 20 damage, against a wizard does from 30 - to damage
     * and against a warrior does 20 - 0 damage
     *
     * @param otherPerson the other person encountered
     * @return the amount of damage done
     */
    public int encounterUgly(People otherPerson) {
        if(otherPerson.getType() == PeopleType.healer)
            return r.nextInt((40 - 20) + 1) + 20;
        else if (otherPerson.getType() == PeopleType.wizard)
            return r.nextInt((30 - 10) + 1) + 10;
        else
            return r.nextInt((20 - 1) + 1) + 1;


    }

    /**
     * Called when otherPerson is from the same nation. He does nothing
     *
     * @param otherPerson the other person encountered
     * @return zero
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
