/**
 * Wizard Strategy
 * Author: Mark Morykan
 */
package Project02;

/**
 * Wizard Strategy
 */
public class MarkWizard extends People {

    /**
     * Call base class constructor with wizard description
     * @param nation Wizard nation name
     * @param tribe Wizard tribe name
     * @param lifePoints Amount of health points
     */
    public MarkWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tMark Wizard";
    }

    /**
     * Wizard does max damage to warrior warrior's health is less than 20 else half damage to warriors.
     * Does one fifth damage to wizards and healers.
     * @param otherPerson Encountered person
     * @return Damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        if (otherPerson.getType().equals(PeopleType.warrior)) {
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

    @Override
    public int encounterSpecial(People otherPerson) {
        return 0;
    }
}
