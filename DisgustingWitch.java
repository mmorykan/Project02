package Project02;

public class DisgustingWitch extends People {

    public DisgustingWitch(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tDisgusting Witch";
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
        otherPerson.addDamageBoost(-10);
        return 0;
    }

}
