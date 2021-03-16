package Project02;

public class MarkHealer extends People {

    public MarkHealer(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tMark Healer";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation().equals(otherPerson.getNation())) {
            lifePoints = this.getLifePoints();
            lifePoints = otherPerson.getType() == PeopleType.warrior ? -lifePoints / 2 : -lifePoints / 3;
        }
        return lifePoints;
    }
}
