package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/*
    TODO:      Check date:
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
*/
public class Validation {
    public static boolean validateDate(String expDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
            try {
                LocalDate date = LocalDate.parse(expDate, dtf);
                return date.getYear() > 1900;
            } catch (DateTimeParseException e) {
                return false;
        }
    }
}
