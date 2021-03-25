/**
 * Wizard Strategy
 * Author: Mark Morykan
 */
package Project02;

/**
 * Wizard Strategy
 */
public class MarkWizard2 extends People {

    /**
     * Call base class constructor with wizard description
     * @param nation Wizard nation name
     * @param tribe Wizard tribe name
     * @param lifePoints Amount of health points
     */
    public MarkWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tMark Wizard";
    }

    /**
     * Wizard does max damage to healer's health if healer's health is less than 20 else half damage to healers.
     * Does one fifth damage to wizards and warriors.
     * @param otherPerson Encountered person
     * @return Damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        if (otherPerson.getType().equals(PeopleType.healer)) {
            return otherPerson.getLifePoints() < 20 ? lifePoints : lifePoints / 2;
        } else {
            return lifePoints / 5;
        }
    }

    /**
     * Wizard does nothing on friendly encounter
     * @param otherPerson Encountered person
     * @return 0 damage points
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
