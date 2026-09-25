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

    public static int inputInt() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result > 0) return result;
                else System.out.println("Enter a valid value!");
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid value!");
                sc.nextLine();
            }
        }
    }

    public static int inputChoice() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result >= 1 && result <= 5) {
                    return result;
                } else {
                    System.out.println("Please input a number in the range 1 -> 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
                sc.next();
            }
        }
    }
}
