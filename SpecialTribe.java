package Project02;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpecialTribe extends Tribe {

    /**
     * Constructor for a tribe. Creates a tribe with the nation it belongs to, tribe name and lifepoints.
     * Makes sure the tribe has at least one of each person type, and fills the rest randomly.
     *
     * @param nation     the nation this tribe will belong to
     * @param tribe      the tribe name
     * @param lifePoints the amount of lifepoints total for the tribe
     */
    public SpecialTribe(String nation, String tribe, int lifePoints) {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        random = new Random();

        List<People> people = Arrays.asList(new MrMiyagi(2),
                new LandMine(2),
                new StealthCloak(2),
                new DisgustingWitch(2),
                new FountainOfHealing(2),
                new SwingMaster(2)
        );

        members.addAll(people);
        livingMembers.addAll(members);
    }
}
