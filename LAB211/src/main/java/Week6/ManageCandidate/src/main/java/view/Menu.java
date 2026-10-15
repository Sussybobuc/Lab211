package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "CANDIDATE MANAGEMENT SYSTEM",
            "1. Experienced",
            "2. Fresher",
            "3. Internship",
            "4. Searching",
            "5. Exit");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
