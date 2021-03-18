package Project02;

import java.util.Random;

public class MarkWarrior extends People {


    public MarkWarrior(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
    }

    public int encounterUgly(People otherPerson) {
        Random random = new Random();
        int lifePoints;
        if (otherPerson.getType().equals(PeopleType.healer)) {
            lifePoints = this.getLifePoints() + random.nextInt(this.getLifePoints());
        } else {
            lifePoints = this.getLifePoints();
        }
        return lifePoints;
    }

    public int encounterFriendly(People otherPerson) {
        return 0;
    }
}
