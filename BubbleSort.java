// CIT300 - Practical Assignment 2
// Member 1 - Bubble Sort Implementation
// This file contains the Bubble Sort algorithm with step counting for comparison.

import java.util.Arrays;

public class BubbleSort {
    public static long bubbleSort(int[] arr) {
        int n = arr.length;
        long steps = 0; // To track number of operations


        //bubble sort algorithm
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return steps;
    }

    // Just for testing my part
    public static void main(String[] args) {
        int[] data = {5, 3, 8, 4, 2};
        int[] copy = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        long steps = bubbleSort(copy);
        long end = System.nanoTime();

        System.out.println("Bubble Sort Result: " + Arrays.toString(copy));
        System.out.println("Steps: " + steps);
        System.out.println("Time (ns): " + (end - start));
    }
}

