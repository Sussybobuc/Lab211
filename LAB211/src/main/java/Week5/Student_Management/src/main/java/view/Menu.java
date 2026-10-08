package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "WELCOME TO STUDENT MANAGEMENT",
            "1. Create",
            "2. Find and Sort",
            "3. Update/Delete",
            "4. Report",
            "5. Exit",
            "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
