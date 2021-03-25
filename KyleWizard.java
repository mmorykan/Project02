/**
 * Kyle Wizard strategy class that determines how a Kyle Wizard
 * character will act in the Warring Nations game. In an ugly
 * encounter, the Wizard will attack if the opponent is a warrior
 * or a healer, attacking a healer more than the warrior. But, if
 * the opponent is a wizard, they will respect the wizard and not
 * attack. In a friendly encounter, the Wizard will leave
 * the other player alone.
 *
 * Author: Kyle Schaedler
 */

package Project02;

import Project02.People;
import Project02.PeopleType;

public class KyleWizard extends People {

    /**
     * KyleWizard constructor creates a Kyle Wizard Character
     * @param nation is what nation the character is from
     * @param tribe is what tribe the character is from
     * @param lifePoints is how many base life points the character has
     */
    public KyleWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tKyle Wizard";
    }

    /**
     * encounterUgly determines how a Kyle Wizard character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getType().equals(PeopleType.warrior)) {
            lifePoints = (int) this.getLifePoints() / 4;
        }
        if (otherPerson.getType().equals(PeopleType.healer)) {
            lifePoints = (int) this.getLifePoints() / 2;
        }
        return lifePoints;
    }

    /**
     * encounterFriendly determines how a Kyle Wizard character will act
     * if the player they encounter is not from the same nation as them
     * @param otherPerson compares to other player in the encounter
     * @return lifePoints that can be used in the encounter
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

}
