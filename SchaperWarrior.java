package Project02;

import Project02.People;
import Project02.PeopleType;


public class SchaperWarrior extends People
{
    public SchaperWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tSchaper Warrior";
    }

    public int encounterUgly(People otherPerson) {
        int lifePoints;
        if (this.getLifePoints() - otherPerson.getLifePoints() > 0)
        {
            lifePoints = otherPerson.getLifePoints();
        }
        else
        {
            lifePoints = this.getLifePoints();
        }
        return lifePoints;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if(otherPerson.getLifePoints() < this.getLifePoints())
        {
            if(otherPerson.getTribe().equals(this.getTribe()))
            {
                lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
            }
            else
            {
                lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
            }
        }

        return lifePoints;
    }

}
