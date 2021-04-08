package Project02;

public class MrMiyagi extends People{

    public MrMiyagi(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.special, lifePoints);
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

    public int doAction(){
        return 10;
    }
}
