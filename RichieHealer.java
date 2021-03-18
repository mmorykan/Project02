package Project02;

import Project02.People;
import Project02.PeopleType;


public class RichieHealer extends Project02.People
{
    public RichieHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tRichie Healer";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (!this.getNation().equals(otherPerson.getNation()))
        {
            if (otherPerson.getLifePoints() < this.getLifePoints())
            {
                if (otherPerson.getType() == PeopleType.warrior) // run away
                {
                    lifePoints = -this.getLifePoints();
                }
            }
        }
        else
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
            {
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            }
        }
        return lifePoints;
    }

    public int encounterUgly(People otherPerson) {
        return 0;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
        {
            lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
        }
        return lifePoints;
    }
}
