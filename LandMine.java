package Project02;

public class LandMine extends People {

    public LandMine(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tLand Mine";
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
        otherPerson.setDead();
        otherPerson.modifyLifePoints(-100);
        return 0;
    }


}
