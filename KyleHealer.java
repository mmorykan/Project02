/**
 * Kyle Healer strategy class that determines how a Kyle Healer
 * character will act in the Warring Nations game. In an ugly
 * encounter, the Healer will attack the opponent lightly. In
 * a friendly encounter, the Healer will heal the player by a
 * randomly generated amount.
 *
 * Author: Kyle Schaedler
 */

package Project02;

import Project02.People;
import Project02.PeopleType;
import Project02.Tribe;
import java.util.Random;

public class KyleHealer extends People {

    /**
     * KyleHealer constructor creates a Kyle Healer Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    Random r = new Random();
    public KyleHealer(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tKyle Healer";
    }

    /**
     * encounterUgly determines how a Kyle Healer character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        if (this.getLifePoints() >= 5)
            return 5;
        else
            return this.getLifePoints();
    }

    /**
     * encounterFriendly determines how a Kyle Healer character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
        return -((int) r.nextInt(100) / 4);
    }

}
