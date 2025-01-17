/**
 * Abstract class representing one character from PeopleTypes.
 * Keeps track of nation, tribe, type and life points of a character.
 * Also declares abstract methods for every character sub-class to implement
 */
package Project02;

import Project02.PeopleType;

/**
 * The People class creates a player in the Warring Nations game.
 * A person is created with a nation and tribe that they belong to,
 * a person type which comes from the PeopleType enum, a description
 * based on their person type, a max amount of life points, and whether
 * or not the player is dead. There are several getters and setters for
 * the dead boolean, getters for the nation, tribe, type, and life points.
 * There is also a method for modifying a person's life points, and
 * abstract methods for ugly and friendly encounters.
 */
public abstract class People {
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    public static final int MAX_LIFE_POINTS = 100;
    private boolean dead;
    private boolean isInvisible;
    private int damageBoost;

    /**
     * Create a person.
     *
     * @param nation     The Nation the person belongs to.
     * @param tribe      The Tribe the person belongs to.
     * @param person     The type of person (Healer, Warrior, or Soldier).
     * @param lifePoints The amount of life points for the person.
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints) {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
        isInvisible = false;
        damageBoost = 0;
    }

    public boolean getInvisible() {
        return isInvisible;
    }

    public void setInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public void addDamageBoost(int damageBoost) {
        this.damageBoost += damageBoost;
    }

    /**
     * Setter for dead boolean.
     */
    public void setDead() {
        dead = true;
    }

    /**
     * Getter for dead boolean.
     *
     * @return boolean if character is dead
     */
    public boolean getDead() {
        return dead;
    }

    /**
     * Getter for PeopleType variable.
     *
     * @return people type for character
     */
    public PeopleType getType() {
        return me;
    }

    /**
     * Getter for character's Tribe.
     *
     * @return tribe that the character is in
     */
    public String getTribe() {
        return myTribe;
    }

    /**
     * Getter for character's Nation.
     *
     * @return nation that the character is in
     */
    public String getNation() {
        return myNation;
    }

    /**
     * Getter for character's Nation.
     *
     */
    public void setNation(String nation) {
        myNation = nation;
    }

    public String getMyDescription(){
        return myDescription;
    }


    /**
     * Determine if the person's life points is greater than 0.
     *
     * @return Boolean determining if the person is still alive.
     */
    public Boolean isPersonAlive() {
        return (myLifePoints > 0);
    }

    /**
     * Getter for character's life points.
     *
     * @return amount of life points given character has
     */
    public int getLifePoints() {
        return myLifePoints;
    }

    /**
     * Modifies the life points of a player.
     *
     * @param points is number of lifePoints to modify
     */
    public void modifyLifePoints(int points) {
        myLifePoints += points;
    }

    /**
     * Abstract method for an ugly encounter
     *
     * @param otherPerson is other player in the encounter
     */
    public abstract int encounterUgly(People otherPerson);

    /**
     * Abstract method for a friendly encounter
     *
     * @param otherPerson is other player in the encounter
     */
    public abstract int encounterFriendly(People otherPerson);

    /**
     * Abstract method for a special encounter
     * @param otherPerson other special player
     */
    public abstract int encounterSpecial(People otherPerson);

    public String toString() {
        return myNation + "\t" + myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints + "\t";
    }
}

