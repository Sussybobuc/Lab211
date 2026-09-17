package model;

public class EastAsiaCountries extends Country {
    private String countryTerrain;
    public EastAsiaCountries(){
    }
    public EastAsiaCountries(float totalArea, String countryName, String countryCode, String countryTerrain) {
        super(totalArea, countryName, countryCode);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20.1f%-20s", countryCode, countryName, totalArea, countryTerrain);

    }
}
