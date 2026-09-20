package view;

import model.Doctor;

import java.util.Arrays;
import java.util.List;

public class menu {

    static List<String> choices = Arrays.asList(
            "========= Doctor Management ==========",
            "1. Add Doctor",
            "2. Update Doctor",
            "3. Delete Doctor",
            "4. View All Doctors",
            "5. Exit");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }

}
