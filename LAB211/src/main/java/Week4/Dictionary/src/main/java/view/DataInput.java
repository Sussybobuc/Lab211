package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    static Scanner sc = new Scanner(System.in);

    public static String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("Enter a valid value!");
            }
        }
    }

    public static int inputChoice() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result >= 1 && result <= 4) {
                    return result;
                } else {
                    System.out.println("Please input a number in the range 1 -> 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
                sc.next();
            }
        }
    }

    public static boolean inputYN(){
        while (true) {
            String input = inputString();
            if (input.equalsIgnoreCase("Y") ||
            input.equalsIgnoreCase("YES")) return true;
            if (input.equalsIgnoreCase("N") ||
            input.equalsIgnoreCase("NO")) return false;
            else System.out.println("Y/yes or N/no");
        }
    }

}
