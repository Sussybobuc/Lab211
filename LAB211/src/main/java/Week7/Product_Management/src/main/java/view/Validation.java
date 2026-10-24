package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validation {

    public static boolean validatePrice(float price) {
        return price >= 0;
    }

    public static boolean validateDate(String expDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                LocalDate date = LocalDate.parse(expDate, dtf);
                return date.getYear() > 1900;
            } catch (DateTimeParseException e) {
                return false;
            }
        }
    }

    public static boolean inputWarranty(int year){
        return year >= 0;
    }
}
