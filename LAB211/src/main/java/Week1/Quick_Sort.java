package Week1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Quick_Sort {
    public static void qSort(int[] arr, int low, int high){
        if (low >= high)
            return;
        int pivot = arr[(low + high)/2];
        int i = low; int j = high;
        while (arr[i] < pivot) i++;
        while (arr[j] > pivot) j--;
        if (i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        qSort(arr, low, j);
        qSort(arr, i, high);
    }
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
        qSort(arr, 0, n-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
