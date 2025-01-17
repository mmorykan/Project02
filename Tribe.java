/**
 * Each Nation gets 5 Tribes each with 6 People: at least 1 warrior, wizard, and healer,
 * and then randomly chosen People.
 */
package Project02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.io.StringBufferInputStream;

import Project02.People;
import Project02.PeopleType;


/**
 * The Tribe Class. Adds people to a tribe and adds the tribe to a nation.
 * Each tribe has a random warrior, wizard, and healer,
 * and then a random last 3 members that can be any personType.
 * <p>
 * Authors: Richie Glennon, Mark Morykan, Kyle Schaedler
 */
public class Tribe {
    protected final int NUMBER_OF_PEOPLE = 6;  // Tribe size
    protected String nationName;
    protected String tribeName;
    protected int tribeLifePoints;
    protected ArrayList<People> members = new ArrayList<>();
    protected ArrayList<People> livingMembers = new ArrayList<>();
    protected Random random;

    public Tribe() {

    }
    /**
     * Constructor for a tribe. Creates a tribe with the nation it belongs to, tribe name and lifepoints.
     * Makes sure the tribe has at least one of each person type, and fills the rest randomly.
     *
     * @param nation     the nation this tribe will belong to
     * @param tribe      the tribe name
     * @param lifePoints the amount of lifepoints total for the tribe
     */
    public Tribe(String nation, String tribe, int lifePoints) {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        random = new Random();

        /* Add one random warrior, wizard, and healer */
        addMember(Arrays.asList(MarkWarrior.class, MarkWarrior2.class,
                RichieWarrior.class, RichieWarrior2.class,
                KyleWarrior.class, KyleWarrior2.class));
        addMember(Arrays.asList(MarkWizard.class, MarkWizard2.class,
                RichieWizard.class, RichieWizard2.class,
                KyleWizard.class, KyleWizard2.class));
        addMember(Arrays.asList(MarkHealer.class, MarkHealer2.class,
                RichieHealer.class, RichieHealer2.class,
                KyleHealer.class, KyleHealer2.class));

        /* List of all people types */
        List<Class<? extends People>> peopleTypes = Arrays.asList(
                MarkHealer.class, MarkWizard.class, MarkWarrior.class,
                MarkHealer2.class, MarkWizard2.class, MarkWarrior2.class,
                RichieHealer.class, RichieWizard.class, RichieWarrior.class,
                RichieWarrior2.class, RichieWizard2.class, RichieHealer2.class,
                KyleHealer.class, KyleWizard.class, KyleWarrior.class,
                KyleHealer2.class, KyleWizard2.class, KyleWarrior2.class);

        /* Add 3 more people to the tribe */
        for (int i = 0; i < 3; i++)
            addMember(peopleTypes);

//        for (int i = 0; i < members.size(); i++)
        livingMembers.addAll(members);
    }

    /**
     * Add a random member to the tribe from a list of peopleTypes
     * @param types The list of characters
     */
    protected void addMember(List<Class<? extends People>> types) {
        int randomNum = random.nextInt(types.size());  // Generate random index of the list
        Constructor<?> constructor = types.get(randomNum).getConstructors()[0];  // Get constructor of class at index
        try {
            members.add((People) constructor.newInstance(nationName, tribeName,
                    tribeLifePoints / NUMBER_OF_PEOPLE));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();  // required to catch Exceptions when using newInstance() method
        }
    }

    /**
     * return an ArrayList of all living tribe members
     *
     * @return ArrayList of people living in the tribe
     */
    public ArrayList<People> getLivingTribeMembers() {
        livingMembers.clear();
        tribeLifePoints = 0;
        for (int person = 0; person < members.size(); person++) {
            if (members.get(person).isPersonAlive()) {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            } else {
                if (!(members.get(person).getDead())) {
                    members.get(person).setDead();
                    System.out.println("\t\t" + members.get(person) + " is dead!");
                }
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/

    /**
     * @return the size of the tribe
     */
    public int getTribeSize() {
        return livingMembers.size();
    }

    /**
     * @return True if at least one member is alive, false otherwise
     */
    public Boolean isTribeAlive() {
        return (tribeLifePoints > 0);
    }

    /**
     * @return the total tribe life points remaining
     */
    public int getTribeLifePoints() {
        return tribeLifePoints;
    }

    /**
     * @return the name of the tribe
     */
    public String getTribeName() {
        return tribeName;
    }

    /**
     * @return String representation of the tribe
     */
    public String toString() {
        String result = "\0";

        result = tribeName;
        for (int i = 0; i < members.size(); i++) {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
