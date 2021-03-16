package Project02;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.io.StringBufferInputStream;

import Project02.People;
import Project02.PeopleType;
import Project02.SchaperWarrior;
import Project02.SchaperWizard;

public class Tribe
{
    private final int NUMBER_OF_PEOPLE = 6;
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();
    private Random random;

    public Tribe(String nation, String tribe, int lifePoints) {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        random = new Random();

        /* Add one random warrior, wizard, and healer */
        addMember(Arrays.asList(SchaperWarrior.class, RichieWarrior.class));
        addMember(Arrays.asList(SchaperWizard.class, RichieWizard.class));
        addMember(Arrays.asList(MarkHealer.class));

        /* List of all people types */
        List<Class<? extends People>> peopleTypes = Arrays.asList(SchaperWarrior.class, SchaperWizard.class,
                MarkHealer.class, RichieWarrior.class, RichieWizard.class);

        /* Add 3 more people to the tribe since we */
        for(int i = 0; i < 3; i++)
            addMember(peopleTypes);

        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Add a random member to the tribe from a list of peopleTypes
     * @param types The list of peopleTypes
     */
    private void addMember(List<Class<? extends People>> types) {
        int randomNum = random.nextInt(types.size());  // Generate random index of the list
        Constructor<?> constructor = types.get(randomNum).getConstructors()[0];  // Get constructor of class at index
        try {
            members.add((People) constructor.newInstance(nationName, tribeName,
                    tribeLifePoints / NUMBER_OF_PEOPLE));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();  // required to catch Exceptions when using newInstance() method
        }
    }

    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
            else
            {
                if(!(members.get(person).getDead()))
                {
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

    public int getTribeSize()
    {
        return livingMembers.size();
    }

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    public String getTribeName()
    {
        return tribeName;
    }

    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
