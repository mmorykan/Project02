package Project02;

import Project02.People;
import Project02.PeopleType;


public class RichieWizard extends Project02.People
{
    public RichieWizard(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tRichie Wizard";
    }

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

    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
