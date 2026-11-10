package view;

public class HLNH_RiceVarietyListView {

    public String[] inputNewRiceVariety() {
        System.out.println("--------- Add New Rice Variety ---------");
        System.out.print("Name: ");
        String name = DataInput.inputString();
        System.out.print("Origin: ");
        String origin = DataInput.inputString();
        String harvestDate = inputHarvestDate();
        String yield = inputYield();
        System.out.print("Disease resistance: ");
        String diseaseResistance = DataInput.inputString();
        return new String[]{name, origin, harvestDate, yield, diseaseResistance};
    }

    private String inputHarvestDate() {
        while (true) {
            System.out.print("Harvest date (dd/MM/yyyy): ");
            String date = DataInput.inputString();
            if (Validation.validateDate(date)) return date;
            System.out.println("Invalid date, please use dd/MM/yyyy.");
        }
    }

    private String inputYield() {
        while (true) {
            System.out.print("Yield (tons/ha): ");
            String yield = DataInput.inputString();
            if (Validation.validateYield(yield)) return yield;
            System.out.println("Invalid number, please try again.");
        }
    }

    public void displayAddResult(boolean added, String name) {
        if (added) {
            System.out.println("Rice variety added successfully!");
        } else {
            System.out.println("Failed to add rice variety! \"" + name + "\" may already exist.");
        }
    }

    public void emptyList() {
        System.out.println("EMPTY RICE VARIETY LIST");
    }

    public void displayAll(String formatted) {
        System.out.println("--------- All Rice Varieties ---------");
        System.out.print(formatted);
    }

    public void displaySorted(String formatted) {
        System.out.println("--------- Rice Varieties Sorted By Name ---------");
        System.out.print(formatted);
    }

    public void displayGrouped(String formatted) {
        System.out.println("--------- Rice Varieties Grouped By Origin ---------");
        System.out.print(formatted);
    }

    public void displayDeleted(String formatted) {
        System.out.println("--------- Deleted Varieties (older than 10 years) ---------");
        if (formatted.isEmpty()) {
            System.out.println("(none)");
        } else {
            System.out.print(formatted);
        }
    }
}
