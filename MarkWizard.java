package Project02;

public class MarkWizard extends People {

    public MarkWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tMark Wizard";
    }

    public int encounterUgly(People otherPerson) {
        return 0;
    }

    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation().equals(otherPerson.getNation())) {
            lifePoints = this.getLifePoints();
            lifePoints = otherPerson.getType() == PeopleType.warrior ? -lifePoints / 2 : -lifePoints / 3;
        }
        return lifePoints;
    }
}
