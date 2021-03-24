/**
 * Strategy for the Healer person type.
 * The RichieHealer2 does 2 damage to a wizard or warrior
 * in an ugly encounter because he is weak, but does 10 to another healer.
 * In a friendly encounter he heals the other player half of their life points
 * Author: Richie Glennon
 */
package Project02;

import Project02.People;
import Project02.PeopleType;


public class RichieHealer2 extends Project02.People {
    /**
     * Create a RichieHealer object
     * @param nation the nation it belongs to
     * @param tribe the tribe it belongs to
     * @param lifePoints the life points he has
     */
    public RichieHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tRichie Healer2";
    }


    /**
     * Called when otherPerson is from another nation.
     * The RichieHealer2 does 2 damage to a wizard or warrior
     * because he is weak, but does 10 to another healer
     * @param otherPerson the person encountered
     * @return the amount of damage dealt
     */
    @Override
    public int encounterUgly(People otherPerson) {
        if (otherPerson.getType() == PeopleType.healer)
            return 10;
        return 2;
    }

    /**
     * Called when otherPerson is from the same nation, heals them half
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
