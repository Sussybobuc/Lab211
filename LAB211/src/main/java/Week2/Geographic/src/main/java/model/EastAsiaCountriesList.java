package model;

import java.util.ArrayList;
import java.util.Comparator;

public class EastAsiaCountriesList {
    private final ArrayList<EastAsiaCountries> EA_ArrayList = new ArrayList<>();

    public ArrayList<EastAsiaCountries> getEA_ArrayList() {
        return EA_ArrayList;
    }

    public void addCountryInformation(EastAsiaCountries country) {
        EA_ArrayList.add(country);
    }

    public EastAsiaCountries getRecentlyEnteredInformation() {
        if (!EA_ArrayList.isEmpty()) {
            return EA_ArrayList.get(EA_ArrayList.size() - 1);
        }
        return null;
    }

    public ArrayList<EastAsiaCountries> searchInformationByName(String name) {
        name = name.toLowerCase();
        ArrayList<EastAsiaCountries> matches = new ArrayList<>();
        for (EastAsiaCountries e : EA_ArrayList) {
            if (e.getCountryName().toLowerCase().contains(name)) {
                matches.add(e);
            }
        }
        return matches;
    }

    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() {
        ArrayList<EastAsiaCountries> result = new ArrayList<>(EA_ArrayList);
        result.sort(Comparator.comparing(Country::getCountryName));
        return result;
    }

}
