package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "========= Rice Variety Management System =========",
            "1. New Rice Variety",
            "2. Display all",
            "3. Sort Varieties based on name",
            "4. Group Varieties based on origin",
            "5. Delete Varieties older than 10 years",
            "6. Exit",
            "======================================");
    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
