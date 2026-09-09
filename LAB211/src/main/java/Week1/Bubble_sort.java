/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Bubble_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("Enter number of array:");
                n = sc.nextInt();
                if (n > 0) {
                    flag = true;
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong input");
                sc.next();
            }
        }
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10 - 1) + 1;
        }
        System.out.print("Unsorted array: " + Arrays.toString(arr));

        boolean notSwapped;
        do {
            notSwapped = true;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    notSwapped = false;
                }
            }
        } while (!notSwapped);
                System.out.print("\nSorted array: " + Arrays.toString(arr));

    }
}
