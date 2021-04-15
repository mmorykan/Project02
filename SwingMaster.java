package Project02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Special person SwingMaster
 * SwingMaster when encountered changes the nation the player is in
 *
 * Author: Richie Glennon
 */
public class SwingMaster extends People{

    /**
     * Creates a SwingMaster in the special tribe and nation
     * @param lifePoints the total lifePoints SwingMaster starts with (should be 2)
     */
    public SwingMaster(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tSwing Master";
    }

    /**
     * Do nothing(should not be called)
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
     * Picks a random nation from the 3 player nations, and sets the nation to it
     * if the new nation is different, the description changes to add "Changed Teams"
     * @param otherPerson is other player in the encounter
     * @return 0
     */
    @Override
    public int encounterSpecial(People otherPerson) {
        Random r = new Random();
        ArrayList<String> nationNames = new ArrayList<>(
                Arrays.asList("Richie's Nation", "Kyle's Nation", "Mark's Nation"));
        otherPerson.setNation(nationNames.get(r.nextInt(2)));
        if(!nationNames.get(r.nextInt(2)).equals(otherPerson.getNation()))
            otherPerson.myDescription = otherPerson.myDescription + "Changed Teams";

        return 0;
    }


}
