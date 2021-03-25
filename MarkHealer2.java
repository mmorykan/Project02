/**
 * Healer strategy
 * Author: Mark Morykan
 */
package Project02;

/**
 * Healer Strategy
 */
public class MarkHealer2 extends People {

    /**
     * Call base class constructor with correct description
     * @param nation Healer nation name
     * @param tribe Healer tribe name
     * @param lifePoints Amount of life points
     */
    public MarkHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tMark Healer 2";
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
     * Healer wizards more than warriors and healers
     * @param otherPerson Encountered person
     * @return The damage points to use
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        return otherPerson.getType() == PeopleType.wizard ? -lifePoints / 2 : -lifePoints / 3;
    }
}
