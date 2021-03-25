/**
 * There are 3 different nations, each with 5 tribes containing 6 People. Every nation gets equal life points.
 * Keeps track of its own population and living population
 */
package Project02;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import Project02.Tribe;
import Project02.People;

/**
 * The Nation class creates nations for the Warring Nations game.
 * Each nation is created with 5 tribes, a nation name, a total
 * number of life points for the nation, and players to populate
 * the nations. The class also has methods to get a nation's population,
 * get a nation's name, and print a tribe's status within the nation.
 */
public class Nation {
    private int nationLifePoints;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * Creates a Nation and adds a fixed amount of tribes to
     * the nation with equal life points.
     *
     * @param name       The name of the Nation.
     * @param lifePoints The amount of life points for the Nation.
     */
    public Nation(String name, int lifePoints) {
        int NUMBER_OF_TRIBES = 5;
        nationName = name;
        nationLifePoints = lifePoints;
        for (int i = 0; i < NUMBER_OF_TRIBES; i++) {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / NUMBER_OF_TRIBES));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * Iterate over all tribes in the Nation and if it has living members,
     * add its life points to the nations life points.
     *
     * @return An ArrayList of living tribes.
     */
    public ArrayList<People> getNationPopulation() {
        nationLifePoints = 0;
        livingPopulation.clear();
        for (int tribe = 0; tribe < this.tribes.size(); tribe++) {
            if (tribes.get(tribe).isTribeAlive()) {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     * Getter function for a player's nation.
     *
     * @return nationName which is the name of the nation
     */
    public String getNationName() {
        return nationName;
    }

    /**
     * Prints the status of the tribes including how many players
     * are still alive and how many are dead in the game.
     */
    public void printTribesStatus() {
        for (int tribe = 0; tribe < 1; tribe++) {
            if (tribes.get(tribe).isTribeAlive()) {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            } else {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    public String toString() {
        String result = "\0";
        result = nationName;
        for (int i = 0; i < tribes.size(); i++) {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
