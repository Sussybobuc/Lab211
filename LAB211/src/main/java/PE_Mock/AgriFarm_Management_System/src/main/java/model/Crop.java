package model;

public class Crop extends FarmOrganism{
    protected String id;
    protected String species;
    protected String fieldZone;
    protected String sowedDate;
    protected double height;

    public Crop(String name, int age, String id, String species, String fieldZone, String sowedDate, double height) {
        super(name, age);
        this.id = id;
        this.species = species;
        this.fieldZone = fieldZone;
        this.sowedDate = sowedDate;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFieldZone() {
        return fieldZone;
    }

    public void setFieldZone(String fieldZone) {
        this.fieldZone = fieldZone;
    }

    public String getSowedDate() {
        return sowedDate;
    }

    public void setSowedDate(String sowedDate) {
        this.sowedDate = sowedDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void grow() {
        height += 5;
    }

    @Override
    public String interact(FarmOrganism other) {
        if (other instanceof Livestock ){
            return "Crop " + getName() + " Feeds Livestock " + other.getName();
        } else if (other instanceof Crop){
            return "Crop " + getName() + " competes for nutrients with Crop " + other.getName();
        } else return "Crop " + getName() + " coexists peacefully";
    }

    @Override
    public String toString() {
        return "Crop," + getName()+','+ getAge()+','
                + id+',' + species+',' + fieldZone + ',' + sowedDate+',' + height;
    }


}
