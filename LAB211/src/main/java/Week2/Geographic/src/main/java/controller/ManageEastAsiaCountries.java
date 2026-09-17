package controller;

import model.EastAsiaCountriesList;
import view.ConsoleForm;
import view.Menu;
import view.Validation;

public class ManageEastAsiaCountries {
    EastAsiaCountriesList eaList = new EastAsiaCountriesList();
    ConsoleForm console = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        eaList.addCountryInformation(console.inputInformation());
                    } while (Validation.inputYN());
                    break;
                case 2:
                    console.displayRecently(eaList.getRecentlyEnteredInformation());
                    break;
                case 3:
                    console.displayList(eaList.searchInformationByName(console.enterSearchName()));
                    break;
                case 4:
                    console.displayList(eaList.sortInformationByAscendingOrder());
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
