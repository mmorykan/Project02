package Project02;

public class MrMiyagi extends People{

    public MrMiyagi(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tMr Miyagi";
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
        return 0;
    }

}
