package Project02;

public class SpecialNation extends Nation {
    /**
     * Creates a Nation and adds a fixed amount of tribes to
     * the nation with equal life points.
     *
     * @param name       The name of the Nation.
     * @param lifePoints The amount of life points for the Nation.
     */
    public SpecialNation(String name, int lifePoints) {
        nationName = name;
        nationLifePoints = lifePoints;
        tribes.add(new SpecialTribe(nationName, "Special", nationLifePoints));

        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }
}
