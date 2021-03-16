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


    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation()))
        {
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
        }
        else
        {
            int points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0)
            {
                lifePoints = otherPerson.getLifePoints();
            }
            else
            {
                lifePoints = this.getLifePoints();
            }
        }
        return lifePoints;
    }

}
