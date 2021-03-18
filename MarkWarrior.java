package Project02;

import Project02.People;
import Project02.PeopleType;


public class MarkWarrior extends People {


    public MarkWarrior(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, person, lifePoints);
    }

    public int encounterUgly(People otherPerson) {
        return 0;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation().equals(otherPerson.getNation())) {
            lifePoints = this.getLifePoints();
            lifePoints = otherPerson.getType() == PeopleType.warrior ? -lifePoints / 2 : -lifePoints / 3;
        }
        return lifePoints;
    }
}
