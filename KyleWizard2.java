/**
 * Kyle Wizard 2 strategy class that determines how a Kyle
 * Wizard 2 character will act in the Warring Nations game. In an ugly
 * encounter, the Wizard will attack offering up a third of their health.
 * In a friendly encounter, the Wizard will offer a third of their health
 * to heal their teammate if they are a warrior.
 *
 * Author: Kyle Schaedler
 */

package Project02;

import Project02.People;
import Project02.PeopleType;

public class KyleWizard2 extends People {

    /**
     * KyleWizard2 constructor creates a Kyle Wizard 2 Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    public KyleWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tKyle Wizard 2";
    }

    /**
     * encounterUgly determines how a Kyle Wizard 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = (int) this.getLifePoints() / 3;

        return lifePoints;
    }

    /**
     * encounterFriendly determines how a Kyle Wizard 2 character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getType() == PeopleType.warrior)
            lifePoints = (this.getLifePoints() - otherPerson.getLifePoints()) / 3;

        return -(lifePoints);
    }

    @Override
    public int encounterSpecial(People otherPerson) {
        return 0;
    }

}
