/**
 * Warrior strategy
 * Author: Mark Morykan
 */
package Project02;

/**
 * Warrior strategy
 */
public class MarkWarrior extends People {

    /**
     * Call constructor from People base class
     * @param nation Warrior nation
     * @param tribe Warrior tribe
     * @param lifePoints Amount of health points
     */
    public MarkWarrior(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tMark Warrior";
    }

    /**
     * Warrior does double damage to healers than other characters
     * @param otherPerson Encountered character
     * @return Damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        if (otherPerson.getType().equals(PeopleType.healer)) {
            return lifePoints;
        } else {
            return lifePoints /2;
        }
    }

    /**
     * Warrior does nothing on a friendly encounter.
     * @param otherPerson Encountered character
     * @return Damage points to use
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
