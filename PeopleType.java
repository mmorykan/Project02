package Project02;

/**
 * Enum for all of the People Types that are assigned
 * to the People object.
 */
public enum PeopleType {
    wizard("wizard"),
    warrior("warrior"),
    healer("healer");

    private String description;

    /**
     * Constructor for PeopleType assigns the types
     * parameter to the description variable.
     *
     * @param types extra identifier for People type
     */
    PeopleType(String types) {
        description = types;
    }

    /**
     * Gets the description of the player.
     *
     * @return description string variable for People type
     */
    public String getDescription() {
        return description;
    }
}
