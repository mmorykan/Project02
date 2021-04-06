/**
 * Healer strategy
 * Author: Mark Morykan
 */
package Project02;

/**
 * Healer Strategy
 */
public class MarkHealer extends People {

    /**
     * Call base class constructor with correct description
     * @param nation Healer nation name
     * @param tribe Healer tribe name
     * @param lifePoints Amount of life points
     */
    public MarkHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tMark Healer";
    }

    /**
     * Healer does nothing for ugly encounters
     * @param otherPerson Encountered person
     * @return 0 damage points for ugly encounter
     */
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    /**
     * Healer warriors more than wizards and healers
     * @param otherPerson Encountered person
     * @return The damage points to use
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        lifePoints = otherPerson.getType() == PeopleType.warrior ? -lifePoints / 2 : -lifePoints / 3;
        return lifePoints;
    }

    @Override
    public int encounterSpecial(People otherPerson) {
        return 0;
    }
}
