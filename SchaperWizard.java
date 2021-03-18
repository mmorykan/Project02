package Project02;

import Project02.People;
import Project02.PeopleType;


public class SchaperWizard extends Project02.People
{
    public SchaperWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tSchaper Wizard";
    }

    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints())
        {
            if (otherPerson.getType() == PeopleType.warrior) // run away
            {
                lifePoints = -this.getLifePoints();
            }
            else // attack a wizard
            {
                lifePoints = (int) (this.getLifePoints()/2);
            }
        }
        return lifePoints;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
        {
            lifePoints = this.getLifePoints() - otherPerson.getLifePoints() / 2;
        }

        return lifePoints;
    }

}
