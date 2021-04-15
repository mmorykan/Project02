package Project02;

/**
 * Special person MrMiyagi
 * Mr. Miyagi when encountered teaches the player karate adn now does 10 more damage per round
 *
 * Author: Richie Glennon
 */
public class MrMiyagi extends People {

    /**
     * Creates a MrMiyagi in the special tribe and nation
     * @param lifePoints the total lifePoints Mr Miyagi starts with (should be 2)
     */
    public MrMiyagi(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tMr Miyagi";
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
     * The only encounter method that will be called, adds 10 to the opponents damage boost
     * @param otherPerson The person encountered
     * @return 0
     */
    @Override
    public int encounterSpecial(People otherPerson) {
        otherPerson.addDamageBoost(10);
        return 0;
    }

}
