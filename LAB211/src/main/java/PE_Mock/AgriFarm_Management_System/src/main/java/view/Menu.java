package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "========= AGRIFARM MANAGEMENT =========",
            "1. Read file",
            "2. Display all",
            "3. Add new Crop",
            "4. Add new Livestock",
            "5. Search organism by name",
            "6. Simulate interaction",
            "7. Exit",
            "======================================");
    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
