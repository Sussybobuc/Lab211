package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DataInput {

    static Scanner sc = new Scanner(System.in);
    static final Pattern phoneRegex = Pattern.compile("^(?=(?:\\D*\\d){10,})[\\d\\s\\-+()]+$");
    static final Pattern emailRegex = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

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

    public static boolean inputYN() {
        while (true) {
            String input = inputString();
            if (input.equalsIgnoreCase("Y") ||
                    input.equalsIgnoreCase("YES")) return true;
            if (input.equalsIgnoreCase("N") ||
                    input.equalsIgnoreCase("NO")) return false;
            else System.out.println("Y/yes or N/no");
        }
    }

    public static String inputBD() {
        while (true) {
            String input = inputString();
            if (input.length() == 4) {
                try {
                    int year = Integer.parseInt(input);
                    if (year > 1900
                            && year <= LocalDate.now().getYear()) return input;
                } catch (NumberFormatException e) {
                    System.out.println("Please input a valid date!");
                }
            }
        }
    }

    public static String inputDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String input = inputString();
            try {
                LocalDate date = LocalDate.parse(input, dtf);
                if (date.getYear() > 1900
                        && date.getYear() <= LocalDate.now().getYear()) return input;
            } catch (DateTimeParseException e) {
                System.out.println("Please input a valid date!");
            }
        }
    }

    public static String inputPhone() {
        while (true) {
            String input = inputString();
            if (phoneRegex.matcher(input).matches()) return input;
            else System.out.println("Please input a valid phone number!");
        }
    }

    public static String inputEmail() {
        while (true) {
            String input = inputString();
            if (emailRegex.matcher(input).matches()) return input;
            else System.out.println("Please input a valid email!");
        }
    }

    public static String inputType() {
        while (true) {
            String input = inputString();
            if (input.equals("0") || input.equals("1") || input.equals("2")) return input;
            else System.out.println("Please input a valid type!");
        }
    }
}
