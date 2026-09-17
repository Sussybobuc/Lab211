package model;

public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country(){
    }
    public Country(float totalArea, String countryName, String countryCode) {
        this.totalArea = totalArea;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20.1f", countryCode, countryName, totalArea);
    }
}
