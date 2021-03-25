
package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * Wizard Strategy
 * Author: Dr. Schaper
 * Modified by Mark Morykan
 */
public class SchaperWizard extends Project02.People {

    /**
     * Call base class constructor with wizard description
     *
     * @param nation     The wizard's nation
     * @param tribe      The wizard's tribe
     * @param lifePoints Amount of health points
     */
    public SchaperWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tSchaper Wizard";
    }

    /**
     * Run away from encountered person if their life points are less and they are warrior.
     * Attack a wizard
     *
     * @param otherPerson Encountered person
     * @return Amount of damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            if (otherPerson.getType() == PeopleType.warrior) // run away
            {
                lifePoints = -this.getLifePoints();
            } else // attack a wizard
            {
                lifePoints = (int) (this.getLifePoints() / 2);
            }
        }
        return lifePoints;
    }

    /**
     * Heal friendly player
     *
     * @param otherPerson Encountered player
     * @return Amount of points to heal friendly player with
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
        {
            lifePoints = this.getLifePoints() - otherPerson.getLifePoints() / 2;
        }

        return lifePoints;
    }

}
