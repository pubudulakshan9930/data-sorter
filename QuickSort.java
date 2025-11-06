// CIT300 - Practical Assignment 2
// Member 3 - Quick Sort Implementation with performance measurement
// Implemented recursive quick sort and step tracking.

import java.util.Arrays;

public class QuickSort {
    static long steps;

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            steps++;
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 8, 4, 2};
        int[] copy = Arrays.copyOf(data, data.length);
        steps = 0;
        long start = System.nanoTime();
        quickSort(copy, 0, copy.length - 1);
        long end = System.nanoTime();

        System.out.println("Quick Sort Result: " + Arrays.toString(copy));
        System.out.println("Steps: " + steps);
        System.out.println("Time (ns): " + (end - start));
    }
}
