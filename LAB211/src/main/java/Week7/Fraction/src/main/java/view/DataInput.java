package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    static Scanner sc = new Scanner(System.in);
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
}
