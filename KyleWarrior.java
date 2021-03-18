package Project02;

import Project02.People;
import Project02.PeopleType;


public class KyleWarrior extends People {

    public KyleWarrior(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tKyle Warrior";
    }

    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getLifePoints() < this.getLifePoints()) {
            lifePoints = otherPerson.getLifePoints();
        }
        else {
            lifePoints = 1;
        }
        return lifePoints;
    }

    public int encounterFriendly(People otherPerson) {
        return 0;
    }

}
