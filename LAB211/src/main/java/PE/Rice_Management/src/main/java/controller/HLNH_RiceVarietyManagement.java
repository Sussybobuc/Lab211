package controller;

import model.HLNH_RiceVarietyList;
import view.HLNH_RiceVarietyListView;
import view.Menu;

public class HLNH_RiceVarietyManagement {
    private static final String DATA_FILE = "rice_varieties_HLNH.txt";

    HLNH_RiceVarietyListView view = new HLNH_RiceVarietyListView();
    HLNH_RiceVarietyList riceVarietyList = new HLNH_RiceVarietyList();

    public void execute() {
        try {
            int loaded = riceVarietyList.readFile(DATA_FILE);
            System.out.println("Loaded " + loaded + " valid rice variety(ies) from " + DATA_FILE);
        } catch (Exception e) {
            System.out.println("Could not read data file \"" + DATA_FILE + "\": " + e.getMessage());
        }

        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    String[] in = view.inputNewRiceVariety();
                    boolean added = riceVarietyList.addRiceVariety(in[0], in[1], in[2], in[3], in[4]);
                    view.displayAddResult(added, in[0]);
                    break;
                case 2:
                    if (riceVarietyList.getSize() == 0) {
                        view.emptyList();
                        break;
                    }
                    view.displayAll(riceVarietyList.formatAll(riceVarietyList.getRiceVarietyList()));
                    break;
                case 3:
                    if (riceVarietyList.getSize() == 0) {
                        view.emptyList();
                        break;
                    }
                    riceVarietyList.sortByName();
                    view.displaySorted(riceVarietyList.formatAll(riceVarietyList.getRiceVarietyList()));
                    break;
                case 4:
                    if (riceVarietyList.getSize() == 0) {
                        view.emptyList();
                        break;
                    }
                    view.displayGrouped(riceVarietyList.formatGroupedByOrigin());
                    break;
                case 5:
                    view.displayDeleted(riceVarietyList.formatAll(riceVarietyList.removeOlderThan10Years()));
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new HLNH_RiceVarietyManagement().execute();
    }
}
