/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Binary_Search {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        int n = -1;
        int s = -1;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("Enter number of array:");
                n = sc.nextInt();
                System.out.println("Enter search value:");
                s = sc.nextInt();
                if (n > 0 && s > 0) {
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
                sc.next();
            }
        }

        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10 - 1) + 1;
        }
        Arrays.sort(arr);
        System.out.print("The array: " + Arrays.toString(arr));
    }
}
