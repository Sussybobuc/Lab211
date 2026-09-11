package Week1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Quick_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean flag = false;
        while(!flag) {
            try {
                System.out.println("Enter number of array:");
                n = sc.nextInt();
                if (n > 0)
                    flag = true;
            } catch (InputMismatchException e){
                System.out.println("Wrong input!");
                sc.next();
            }

        }
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(10-1)+1;
        }
        System.out.println("Unsorted array: " + Arrays.toString(arr));


        //int p = arr[n/2];

    }
}
