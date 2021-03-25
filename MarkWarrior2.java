package Project02;

public class MarkWarrior2 extends People {

    /**
     * Call constructor from People base class
     * @param nation Warrior nation
     * @param tribe Warrior tribe
     * @param lifePoints Amount of health points
     */
    MarkWarrior2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
    }

    /**
     * Warrior does double damage to wizards than other characters
     * @param otherPerson Encountered character
     * @return Damage points to use
     */
    public int encounterUgly(People otherPerson) {
        int lifePoints = this.getLifePoints();
        if (otherPerson.getType().equals(PeopleType.wizard)) {
            return lifePoints;
        } else {
            return lifePoints / 2;
        }
    }

    /**
     * Warrior gains half health from friendly warrior in same tribe or one fifth health from warrior in other tribe.
     * @param otherPerson Encountered character
     * @return Damage points to use
     */
    public int encounterFriendly(People otherPerson) {
        int lifePoints = 0;
        if (otherPerson.getType().equals(PeopleType.warrior)) {
            lifePoints = this.getLifePoints();
            if (this.getTribe().equals(otherPerson.getTribe())) lifePoints /= -2;
            else lifePoints /= -5;
        }
        return lifePoints;
    }
}
