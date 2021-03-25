/**
 * Kyle Warrior strategy class that determines how a Kyle Warrior
 * character will act in the Warring Nations game. In an ugly
 * encounter, the Warrior will try to take out an opponent
 * completely if they have less life points than them, but play
 * it safe and attack lightly if they have greater than or equal
 * life points. In a friendly encounter, the Warrior will leave
 * the other player alone.
 *
 * Author: Kyle Schaedler
 */

package Project02;

import Project02.People;
import Project02.PeopleType;

public class KyleWarrior extends People {

    /**
     * KyleWarrior constructor creates a Kyle Warrior Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    public KyleWarrior(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tKyle Warrior";
    }

    /**
     * encounterUgly determines how a Kyle Warrior character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            lifePoints = otherPerson.getLifePoints();
        }
        else {
            lifePoints = 10;
        }
        return lifePoints;
    }

    /**
     * encounterFriendly determines how a Kyle Warrior character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

}
