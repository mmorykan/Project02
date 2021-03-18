package Project02;

import Project02.People;
import Project02.PeopleType;


public class KyleWizard extends People {

    public KyleWizard(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tKyle Wizard";
    }

    public int encounterUgly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getType().equals(PeopleType.warrior)) {
            lifePoints = (int) this.getLifePoints() / 4;
        }
        if (otherPerson.getType().equals(PeopleType.healer)) {
            lifePoints = (int) this.getLifePoints() / 2;
        }
        return lifePoints;
    }

    public int encounterFriendly(People otherPerson) {
        return 0;
    }

}
