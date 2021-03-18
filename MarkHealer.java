package Project02;

public class MarkHealer extends People {

    public MarkHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tMark Healer";
    }

    public int encounterUgly(People otherPerson) {
        return 0;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        lifePoints = otherPerson.getType() == PeopleType.warrior ? -lifePoints / 2 : -lifePoints / 3;
        return lifePoints;
    }
}
