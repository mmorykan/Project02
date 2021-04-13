package Project02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SwingMaster extends People{

    public SwingMaster(int lifePoints) {
        super("Special Nation", "Special Tribe", PeopleType.special, lifePoints);
        myDescription = "\tSwing Master";
    }

    @Override
    public int encounterUgly(People otherPerson) {
        return 0;
    }

    @Override
    public int encounterFriendly(People otherPerson) {
        return 0;
    }

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
