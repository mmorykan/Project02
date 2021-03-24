
package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * Warrior Strategy
 * Author: Dr. Schaper
 * Modified by Mark Morykan
 */
public class SchaperWarrior extends People {

    /**
     * Call base class constructor with warrior description
     *
     * @param nation     Nation of warrior
     * @param tribe      Tribe of warrior
     * @param lifePoints Amount of life points
     */
    public SchaperWarrior(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tSchaper Warrior";
    }

    /**
     * Use all opponents life points as damage if the difference in health is greater than 0. Else, use own points
     *
     * @param otherPerson Encounters person
     * @return Damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints;
        if (this.getLifePoints() - otherPerson.getLifePoints() > 0) {
            lifePoints = otherPerson.getLifePoints();
        } else {
            lifePoints = this.getLifePoints();
        }
        return lifePoints;
    }

    /**
     * Heal during friendly encounters
     *
     * @param otherPerson Encountered character
     * @return The amount of damage points to use
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            if (otherPerson.getTribe().equals(this.getTribe())) {
                lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
            } else {
                lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
            }
        }

        return lifePoints;
    }

}
