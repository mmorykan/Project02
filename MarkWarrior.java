package Project02;

public class MarkWarrior extends People {


    public MarkWarrior(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, person, lifePoints);
    }

    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}
