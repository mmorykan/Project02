package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * Strategy for the wizard person type.
 * The RichieWizard does more damage than a regular SchaperWizard, in an ugly encounter,
 * and does nothing in a friendly encounter
 * <p>
 * Author: Richie Glennon
 */
public class RichieWizard2 extends Project02.People {
    /**
     * Create a RichieWizard2 object
     *
     * @param nation     the name of the nation he belongs to
     * @param tribe      the name of the tribe he belongs to
     * @param lifePoints the amount of life points he has
     */
    public RichieWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tRichie Wizard2";
    }

    /**
     * Called when the person encountered is from another nation. Deals 1/4 of his damage to a warrior,
     * a very strong attack of his health to a wizard, or half to a healer
     * and 1/2 to a healer or wizard
     *
     * @param otherPerson the person encountered
     * @return the amount of damage dealt
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            if (otherPerson.getType() == PeopleType.warrior) // attack a warrior
            {
                lifePoints = (int) (this.getLifePoints() / 4);
            } else if (otherPerson.getType() == PeopleType.wizard)// attack a wizard or healer
            {
                lifePoints = (int) (this.getLifePoints());
            } else
                lifePoints = (int) (this.getLifePoints() / 2);
        }
        return lifePoints;
    }

    /**
     * Called when the person encountered is from the same nation. He does nothing and returns 0.
     *
     * @param otherPerson the person encountered
     * @return zero
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
