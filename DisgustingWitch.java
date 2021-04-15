package Project02;

/**
 * Special person DisgustingWitch
 * The DisgustingWitch when encountered curses players to do 10 less damage per round
 *
 * Author: Kyle Schaedler
 */
public class DisgustingWitch extends People {

    /**
     * Creates a DisgustingWitch in the special tribe and nation
     * @param lifePoints the total lifePoints the disgusting witch starts with (should be 2)
     */
    public DisgustingWitch(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tDisgusting Witch";
    }

    /**
     * Do nothing (Should not be called)
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    @Override
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    /**
     * Do nothing(should not be called)
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    @Override
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

    /**
     * The only encounter method that will be called, subtracts 10 from the opponents damage boost
     * @param otherPerson The person encountered
     * @return 0
     */
    @Override
    public int encounterSpecial(People otherPerson) {
        otherPerson.addDamageBoost(-10);
        return 0;
    }

}
