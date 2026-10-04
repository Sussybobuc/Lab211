/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Menu {
        static List<String> choices = Arrays.asList(
            "========= Task program =========",
            "1. Add Task",
            "2. Delete Task",
            "3. Display Task",
            "4. Exit");

    public static int getChoice() {
        choices.forEach(System.out::println);
        return DataInput.inputChoice();
    }
}
