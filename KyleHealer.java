package Project02;

import Project02.People;
import Project02.PeopleType;
import java.util.Random;

public class KyleHealer extends People {

    Random r = new Random();
    public KyleHealer(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tKyle Healer";
    }

    public int encounterUgly(People otherPerson) {
        return 5;
    }

    public int encounterFriendly(People otherPerson) {
        return r.nextInt(100);
    }

}
