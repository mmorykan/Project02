/**
 * Header
 */
package Project02;

import Project02.People;
import Project02.PeopleType;


public class RichieWizard extends Project02.People
{
    /**
     * Create a RichieWizard object
     * @param nation the name of the nation he belongs to
     * @param tribe the name of the tribe he belongs to
     * @param lifePoints the amount of life points he has
     */
    public RichieWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tRichie Wizard";
    }

    /**
     * Called when the person encountered is from another nation. Deals 1/3 of his damage to a warrior
     * and 1/2 to a healer or wizard
     * @param otherPerson the person encountered
     * @return the amount of damage dealt
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            if (otherPerson.getType() == PeopleType.warrior) // attack a warrior
            {
                lifePoints = (int) (this.getLifePoints() / 3);
            } else // attack a wizard or healer
            {
                lifePoints = (int) (this.getLifePoints() / 2);
            }
        }
        return lifePoints;
    }

    /**
     * Called when the person encountered is from the same nation. Returns 0.
     * @param otherPerson the person encountered
     * @return zero
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
