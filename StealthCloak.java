package Project02;

/**
 * Special person StealthCloak
 * The StealthCloak when encountered makes the player invisible for a round and can take no damage
 *
 * Author: Mark Morykan
 */
public class StealthCloak extends People {

    /**
     * Creates a StealthCloak in the special tribe and nation
     * @param lifePoints the total lifePoints the StealthCloak starts with (should be 2)
     */
    public StealthCloak(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tStealth Cloak";
    }

    /**
     * Do nothing (Should not be called)
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    public int encounterUgly(People otherPerson) {
        if (otherPerson.getInvisible()) return 0;

        return 0;
    }

    /**
     * Do nothing (Should not be called)
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

    /**
     * The only encounter method that should be called, sets the other person to invisible
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    public int encounterSpecial(People otherPerson) {
        otherPerson.setInvisible(true);
        return 0;
    }
}
