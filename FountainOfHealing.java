package Project02;

/**
 * Special person Fountain of Healing
 * The Fountain of Healing when encountered helps players and gives them 30 lifepoints
 *
 * Author: Kyle Schaedler
 */
public class FountainOfHealing extends People {
    /**
     * Creates a fountain of healing in the special tribe and nation
     * @param lifePoints the total lifePoints the fountain of healing starts with (should be 2)
     */
    public FountainOfHealing(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tFountain of Healing";
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
     * Do nothing (Should not be called)
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    @Override
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

    /**
     * The only encounter method that should be called, heals players 30 points
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    @Override
    public int encounterSpecial(People otherPerson) {
        otherPerson.modifyLifePoints(30);
        return 0;
    }

}
