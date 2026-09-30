package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "======== Dictionary program ========",
            "1. Add Word",
            "2. Delete Word",
            "3. Translate",
            "4. Exit");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
