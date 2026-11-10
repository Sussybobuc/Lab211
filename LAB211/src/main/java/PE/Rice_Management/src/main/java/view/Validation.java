package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validation {

    public static boolean validateDate(String harvestDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(harvestDate, dtf);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validateYield(String yield) {
        try {
            return Double.parseDouble(yield) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
