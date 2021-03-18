package Project02;

import Project02.People;
import Project02.PeopleType;

import java.util.Random;


public class RichieWarrior extends People
{
    Random r = new Random();
    public RichieWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tRichie Warrior";
    }



    public int encounterUgly(People otherPerson) {
        return r.nextInt(100);
    }

    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
