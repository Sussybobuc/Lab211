
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
    public static int bSearch(int[] arr, int s, int l, int r) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (arr[mid] == s)
            return mid;
        else if (s > arr[mid])
            return bSearch(arr, s, mid + 1, r);
        else
            return bSearch(arr, s, l, mid - 1);
    }

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
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int index = bSearch(arr, s, 0, n - 1);
        if (index != -1)
            System.out.println("Found " + s + "at index " + index);
        else
            System.out.println("Not found!");
    }
}