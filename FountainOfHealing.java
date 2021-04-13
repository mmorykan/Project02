package Project02;

public class FountainOfHealing extends People {

    public FountainOfHealing(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tFountain of Healing";
    }

    @Override
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    @Override
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

    @Override
    public int encounterSpecial(People otherPerson) {
        otherPerson.modifyLifePoints(30);
        return 0;
    }

}
