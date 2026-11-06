package model;

public class Livestock extends FarmOrganism{
    protected String species;
    protected double weight;
    protected String dietType;

    public Livestock(String name, int age, String species, double weight, String dietType) {
        super(name, age);
        this.species = species;
        this.weight = weight;
        this.dietType = dietType;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public Livestock(String name, int age) {
        super(name, age);

    }

    @Override
    public void grow() {
        weight += 2.0;
    }

    @Override
    public String interact(FarmOrganism other) {
        if (other instanceof Crop && getDietType().equals("Herbivore"))
            return "Livestock " + getName() + " eats Crop " + other.getName();
        else if (other instanceof Crop && getDietType().equals("Omnivore"))
            return "Livestock " + getName() + " pecks around Crop " + other.getName();
        else if (other instanceof  Livestock)
            return "Livestock " + getName() + " interacts with " + other.getName();
        else return getName() + " ignores "  + other.getName();
    }

    @Override
    public String toString() {
        return "Livestock," + getName()+','+ getAge()+','
                + species+',' + weight +',' + dietType;    }
}
