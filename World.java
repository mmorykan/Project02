/**
 * Runs the game for a specific amount of rounds, keeping track of all nations and living nations
 * as well as creating the world
 */
package Project02;

import Project02.Nation;
import Project02.People;

import java.util.*;


/**
 * The World Class. Simulates the game by creating the world with nations,
 * and running a specified amount of rounds.
 * Each round all the people will have an encounter which can be either ugly or friendly.
 * A round is over once all people have had one encounter or all people have died.
 * This repeats for the specified number of rounds
 * <p>
 * Authors: Richie Glennon, Mark Morykan, Kyle Schaedler
 */
public class World {
    private final int worldLifePoints = 4000;
    private final int numberOfRounds = 40;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();


    Random generator;
    ArrayList<People> worldCreatedPeople = new ArrayList<>();


    public World() {
        // seed for psuedo-random number generator
        Date seed = new Date();
        generator = new Random(seed.getTime());
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }

    /**
     * Simulate the game. If there are people still alive from other nations,
     * play one round. Repeat until there are no nations left or you reach 40 rounds.
     * At the end, print the remaining people or if all nations were destroyed.
     */
    public void war() {
        String nationColor = "";
        String resetColor = "\u001B[0m";

        ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

        for (int round = 1; round < numberOfRounds; round++) {
            Set<String> survivingNations = new HashSet<>();
            System.out.println("Round number: " + round);
            worldSurvivingPeople.clear();
            worldSurvivingPeople.addAll(getWorldSurvivingPeople());
            survivingNations.addAll(getSurvivingNations());
            if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1))
                playOneRound(worldSurvivingPeople);
            else {
                System.out.print("Game is over! Winning Nation is: ");
                if (survivingNations.size() == 0) {
                    System.out.println("All Nations Destroyed.");
                } else {
                    System.out.println(survivingNations);
                    System.out.println("The survivors are:");

                    if ("Mark's Nation".equals(worldCreatedPeople.get(worldSurvivingPeople.get(0)).getNation())) {
                        nationColor = "\u001B[32m";
                    } else if ("Richie's Nation".equals(worldCreatedPeople.get(worldSurvivingPeople.get(0)).getNation())) {
                        nationColor = "\u001B[34m";
                    } else if ("Kyle's Nation".equals(worldCreatedPeople.get(worldSurvivingPeople.get(0)).getNation())) {
                        nationColor = "\u001B[31m";
                    }
                    for (Integer worldSurvivingPerson : worldSurvivingPeople) {
                        System.out.println(nationColor + worldCreatedPeople.get(worldSurvivingPerson) + resetColor);
                    }

                }
                break;
            }

        }

    }


    /**
     * Add the warring nations to the world. There is one for each group member.
     */
    public void createWorld() {
        int NUMBER_OF_NATIONS = 3;
        allNations.add(new Nation("Richie's Nation", (worldLifePoints) / NUMBER_OF_NATIONS));
        allNations.add(new Nation("Mark's Nation", (worldLifePoints) / NUMBER_OF_NATIONS));
        allNations.add(new Nation("Kyle's Nation", (worldLifePoints) / NUMBER_OF_NATIONS));
    }


    /**
     * get all the people created in the world.
     *
     * @return an ArrayList of all the people who have been created
     */
    public ArrayList<People> getWorldCreatedPopulation() {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for (int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }


    /**
     * get all the people in the world with life points left
     *
     * @return an ArrayList of all the living people in the world
     */
    public ArrayList<Integer> getWorldSurvivingPeople() {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (Integer i = 0; i < worldCreatedPeople.size(); i++) {
            if (worldCreatedPeople.get(i).isPersonAlive()) {
                survivors.add(i);
            }
        }
        return survivors;
    }


    /**
     * return all the nations with at least one person still alive
     *
     * @return the set of nations with at least one member still alive
     */
    public Set<String> getSurvivingNations() {
        Set<String> survivingNations = new HashSet<>();

        for (Integer i = 0; i < worldCreatedPeople.size(); i++) {
            if (worldCreatedPeople.get(i).isPersonAlive()) {
                survivingNations.add(worldCreatedPeople.get(i).getNation());
            }
        }
        return survivingNations;
    }


    /**
     * @param person1 the first person in the encounter
     * @param person2 the second person in the encounter
     */
    public void encounter(Integer person1, Integer person2) {
        String player1Color = "", player2Color = "";
        String resetColor = "\u001B[0m";

        int person1LifePointsToUse, person2LifePointsToUse;
        People player1 = worldCreatedPeople.get(person1), player2 = worldCreatedPeople.get(person2);
        String player1Nation = player1.getNation(), player2Nation = player2.getNation();
        if ("Mark's Nation".equals(player1Nation)) {
            player1Color = "\u001B[32m";
        } else if ("Richie's Nation".equals(player1Nation)) {
            player1Color = "\u001B[34m";
        } else if ("Kyle's Nation".equals(player1Nation)) {
            player1Color = "\u001B[31m";
        }
        if ("Mark's Nation".equals(player2Nation)) {
            player2Color = "\u001B[32m";
        } else if ("Richie's Nation".equals(player2Nation)) {
            player2Color = "\u001B[34m";
        } else if ("Kyle's Nation".equals(player2Nation)) {
            player2Color = "\u001B[31m";
        }
        System.out.println("Encounter: " + player1Color + player1 + player2Color + player2 + resetColor);

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        if (player1.getNation().equals(player2.getNation())) {
            person1LifePointsToUse = player1.encounterFriendly(player2);
            person2LifePointsToUse = player2.encounterFriendly(player1);
        } else {
            person1LifePointsToUse = player1.encounterUgly(player2);
            person2LifePointsToUse = player2.encounterUgly(player1);
        }

        // amount of life points actually used is subject to a psuedo-random encounter
        int p1damage = (int) (generator.nextFloat() * person1LifePointsToUse);
        int p2damage = (int) (generator.nextFloat() * person2LifePointsToUse);

        if (p1damage > 0 && p2damage > 0)  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage = (int) (generator.nextFloat() * p1damage);
            p1damage = (int) (generator.nextFloat() * p2damage);
        } else if (p1damage > 0) // person 1 is fighting and person 2 is running
        {
            p2damage = (int) (generator.nextFloat() * (p1damage / 3));
        } else if (p2damage > 0) // person 2 is fighting and person 1 is running
        {
            p1damage = (int) (generator.nextFloat() * (p2damage / 3));
        } else // friendly encounter, do nothing
        {

        }

        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        player1.modifyLifePoints((-p2damage));
        player2.modifyLifePoints((-p1damage));
        int player1LifePoints = player1.getLifePoints(), player2LifePoints = player2.getLifePoints();
        if (player1LifePoints > People.MAX_LIFE_POINTS) player1.modifyLifePoints(People.MAX_LIFE_POINTS - player1LifePoints);
        if (player2LifePoints > People.MAX_LIFE_POINTS) player2.modifyLifePoints(People.MAX_LIFE_POINTS - player2LifePoints);


        // Both people lose 1 life point per encounter due to aging
        player1.modifyLifePoints((-1));
        player2.modifyLifePoints((-1));

    }

    /**
     * Shuffle the list of combatants and then pick 2 to have an encounter until there are none left
     *
     * @param combatants the list of people to have encounters in this round
     */
    public void playOneRound(ArrayList<Integer> combatants) {
        System.out.println(combatants.size());
        ArrayList<Integer> survivors = new ArrayList<>();
        Integer numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size() - 1;
        Integer combatantIndex = 0;
        while (combatantIndex < numberOfCombatants) {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex + 1));
            combatantIndex += 2;
        }
    }


}
