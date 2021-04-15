package Project02;

/**
 * Special person Landmine
 * Landmine when encountered blows up the player and kills them
 *
 * Author: Richie Glennon
 */
public class LandMine extends People{

    /**
     * Creates a LandMine in the special tribe and nation
     * @param lifePoints the total lifePoints the Landmine starts with (should be 2)
     */
    public LandMine(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tLand Mine";
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
     * Kills the other player
     * @param otherPerson other special player
     * @return 0
     */
    @Override
    public int encounterSpecial(People otherPerson) {
        otherPerson.setDead();
        otherPerson.modifyLifePoints(-100);
        return 0;
    }


}
