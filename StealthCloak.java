package Project02;

public class StealthCloak extends People {

    public StealthCloak(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tStealth Cloak";
    }

    public int encounterUgly(People otherPerson) {
        if (otherPerson.getInvisible()) return 0;

        return 0;
    }

    public int encounterFriendly(People otherPerson) {
        return 0;
    }

    public int encounterSpecial(People otherPerson) {
        otherPerson.setInvisible(true);
        return 0;
    }
}
