package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/* TODO:
    regex1 = "^\\d{10}$";
    regex2 = "^\\d{3}-\\d{3}-\\d{4}$";
    regex3 = "^\\d{3}-\\d{3}-\\d{4} x\\d{4}$";
    regex4 = "^\\d{3}-\\d{3}-\\d{4} ext\\d{4}$";
    regex5 = "^\\d{3}[.]\\d{3}[.]\\d{4}";
    regex6 = "^\\d{3} \\d{3} \\d{4}";
 */
public class DataInput {

    static Scanner sc = new Scanner(System.in);
    static String regex1 = "^\\d{10}$";
    static String regex2 = "^\\d{3}-\\d{3}-\\d{4}$";
    static String regex3 = "^\\d{3}-\\d{3}-\\d{4} x\\d{4}$";
    static String regex4 = "^\\d{3}-\\d{3}-\\d{4} ext\\d{4}$";
    static String regex5 = "^\\d{3}[.]\\d{3}[.]\\d{4}";
    static String regex6 = "^\\d{3} \\d{3} \\d{4}";

    public static String inputString() {
        while (true) {
            String result = sc.nextLine();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("Enter a valid value!");
            }
        }
    }

    public static String inputPhone() {
        while (true) {
            String input = inputString();
            if (!input.matches(regex1)
                    && !input.matches(regex2)
                    && !input.matches(regex3)
                    && !input.matches(regex4)
                    && !input.matches(regex5)
                    && !input.matches(regex6)) {
                System.out.println("Please input Phone flow\n"
                        + "• 1234567890\n"
                        + "• 123-456-7890\n"
                        + "• 123-456-7890 x1234\n"
                        + "• 123-456-7890 ext1234\n"
                        + "• 123.456.7890\n"
                        + "• 123 456 7890");
                System.out.print("Enter Phone: ");
            }
            else return input;
        }
    }

    public static int inputID() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result > 0) {
                    return result;
                } else {
                    System.out.println("Invalid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ID is digit");
                sc.next();
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
}
