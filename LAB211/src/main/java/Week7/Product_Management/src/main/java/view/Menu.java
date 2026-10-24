package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "PRODUCT MANAGEMENT SYSTEM",
            "1. Add a new product (0: Electronics, 1: Furniture, 2: Food)",
            "2. Display the information of the most recently added product",
            "3. Search for a product by name",
            "4. Update a product by product ID",
            "5. Delete a product by product ID",
            "6. Exit");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
