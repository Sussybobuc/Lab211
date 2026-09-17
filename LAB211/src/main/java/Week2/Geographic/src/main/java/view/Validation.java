package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    public static String inputString() {
        while (true) {
            String result = sc.nextLine();
            if (!result.isEmpty()) return result;
            else {
                System.out.println("Enter a valid string!");
            }
        }
    }

    public static int positiveInt() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result > 0) return result;
                else System.out.println("Please input a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
                sc.next();
            }
        }
    }

    public static int inputChoice() {
        while (true) {
            int result = positiveInt();
            if (result >= 1 && result <= 5) {
                return result;
            } else
                System.out.println("Please input a number in the range 1 -> 5");
        }
    }

    public static float positiveFloat() {
        while (true) {
            try {
                float result = sc.nextFloat();
                sc.nextLine();
                if (result > 0)  return result;
                else System.out.println("Please input a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Please input a number");
            }
        }
    }

    public static boolean inputYN() {
        System.out.println("Do you want to continue?");
        while (true) {
            String input = inputString();
            if (input.equalsIgnoreCase("Y")) return true;
            else if (input.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("Please input Y/y or N/n");
            }
        }
    }
}
