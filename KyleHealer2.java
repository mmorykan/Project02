/**
 * Kyle Healer 2 strategy class that determines how a Kyle
 * Healer 2 character will act in the Warring Nations game. In an ugly
 * encounter, the Healer will leave the other player alone. In a friendly
 * encounter, the Healer will try to heal their ally completely, offering
 * all of their health.
 */

package Project02;

import Project02.People;
import Project02.PeopleType;

public class KyleHealer2 extends People {

    /**
     * KyleHealer2 constructor creates a Kyle Healer 2 Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    public KyleHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tKyle Healer 2";
    }

    /**
     * encounterUgly determines how a Kyle Healer 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    /**
     * encounterFriendly determines how a Kyle Healer 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
        return this.getLifePoints();
    }

}
