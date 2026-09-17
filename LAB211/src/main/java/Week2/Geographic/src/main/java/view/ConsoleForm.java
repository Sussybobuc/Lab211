package view;

import model.EastAsiaCountries;

import java.util.ArrayList;

public class ConsoleForm {

    public EastAsiaCountries inputInformation() {
        EastAsiaCountries eaCountry = new EastAsiaCountries();
        System.out.println("Enter code of country:");
        eaCountry.setCountryCode(Validation.inputString());
        System.out.println("Enter name of country:");
        eaCountry.setCountryName(Validation.inputString());
        System.out.println("Enter total Area:");
        eaCountry.setTotalArea(Validation.positiveFloat());
        System.out.println("Enter terrain of country:");
        eaCountry.setCountryTerrain(Validation.inputString());
        return eaCountry;
    }

    public void displayRecently(EastAsiaCountries countries) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        System.out.printf(countries.toString() + "\n");
    }

    public String enterSearchName() {
        System.out.println("Enter the name you want to search for:");
        return Validation.inputString();
    }

    public void displayList(ArrayList<EastAsiaCountries> eaList) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries e : eaList) {
            System.out.printf(e.toString() + "\n");
        }
    }
}
