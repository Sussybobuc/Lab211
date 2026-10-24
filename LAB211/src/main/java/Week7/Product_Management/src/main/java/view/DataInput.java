package view;


import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    static Scanner sc = new Scanner(System.in);

    public static int inputChoice() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result >= 1 && result <= 6) {
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

    public static int inputType() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result >= 0 && result <= 2) {
                    return result;
                } else {
                    System.out.println("Please input from range 0 -> 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
            }
        }
    }

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

    public static String updateString() {
        return sc.nextLine().trim();
    }

    public static int inputInt() {
        while (true) {
            try {
                String result = inputString();
                return Integer.parseInt(result);
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
            }
        }
    }

    public static float inputFloat() {
        while (true) {
            try {
                String result = inputString();
                return Float.parseFloat(result);
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid value!");
            }
        }
    }


}
