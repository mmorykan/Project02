/**
 * Kyle Warrior 2 strategy class that determines how a Kyle
 * Warrior 2 character will act in the Warring Nations game. In an ugly
 * encounter, the Warrior will attack offering up all of their health
 * regardless of the opponent. In a friendly encounter, the Warrior will
 * leave the other player alone.
 */

package Project02;

import Project02.People;
import Project02.PeopleType;

public class KyleWarrior2 extends People {

    /**
     * KyleWizard2 constructor creates a Kyle Wizard 2 Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    public KyleWarrior2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tKyle Warrior 2";
    }

    /**
     * encounterUgly determines how a Kyle Warrior 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        return this.getLifePoints();
    }

    /**
     * encounterFriendly determines how a Kyle Warrior 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
       return 0;
    }

}
