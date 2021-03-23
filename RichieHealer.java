/**
 * Header
 */
package Project02;

import Project02.People;
import Project02.PeopleType;


public class RichieHealer extends Project02.People
{
    /**
     * Create a RichieHealer object
     * @param nation the nation it belongs to
     * @param tribe the tribe it belongs to
     * @param lifePoints the life points he has
     */
    public RichieHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tRichie Healer";
    }


    /**
     * Called when otherPerson is from another nation.
     * The RichieHealer does not attack
     * @param otherPerson the person encountered
     * @return the amount of damage dealt
     */
    @Override
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    /**
     * Called when otherPerson is from the same nation
     * @param otherPerson the person encountered
     * @return the amount of life points given away to a friendly person
     */
    @Override
    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
        {
            lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
        }
        return lifePoints;
    }
}
