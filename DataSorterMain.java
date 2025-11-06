// CIT300 - Practical Assignment 2
// Member 4 - Integration, Menu System, and Performance Comparison
// This part combines all sorting classes and handles user interaction.

import java.util.*;

public class DataSorterMain {
    private static Scanner sc = new Scanner(System.in);
    private static int[] dataset;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandom();
                case 3 -> runBubble();
                case 4 -> runMerge();
                case 5 -> runQuick();
                case 6 -> compareAll();
                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 7);
    }

    private static void enterNumbers() {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        dataset = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) dataset[i] = sc.nextInt();
    }

    private static void generateRandom() {
        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();
        Random rand = new Random();
        dataset = new int[n];
        for (int i = 0; i < n; i++) dataset[i] = rand.nextInt(1000);
        System.out.println("Random dataset generated!");
    }

    private static void runBubble() {
        int[] copy = Arrays.copyOf(dataset, dataset.length);
        long start = System.nanoTime();
        long steps = BubbleSort.bubbleSort(copy);
        long end = System.nanoTime();
        System.out.println("Bubble Sorted: " + Arrays.toString(copy));
        System.out.println("Time (ns): " + (end - start) + " | Steps: " + steps);
    }

    private static void runMerge() {
        int[] copy = Arrays.copyOf(dataset, dataset.length);
        MergeSort.steps = 0;
        long start = System.nanoTime();
        MergeSort.mergeSort(copy, 0, copy.length - 1);
        long end = System.nanoTime();
        System.out.println("Merge Sorted: " + Arrays.toString(copy));
        System.out.println("Time (ns): " + (end - start) + " | Steps: " + MergeSort.steps);
    }

    private static void runQuick() {
        int[] copy = Arrays.copyOf(dataset, dataset.length);
        QuickSort.steps = 0;
        long start = System.nanoTime();
        QuickSort.quickSort(copy, 0, copy.length - 1);
        long end = System.nanoTime();
        System.out.println("Quick Sorted: " + Arrays.toString(copy));
        System.out.println("Time (ns): " + (end - start) + " | Steps: " + QuickSort.steps);
    }

    private static void compareAll() {
        if (dataset == null) {
            System.out.println("Please create dataset first!");
            return;
        }
        int[] data1 = Arrays.copyOf(dataset, dataset.length);
        int[] data2 = Arrays.copyOf(dataset, dataset.length);
        int[] data3 = Arrays.copyOf(dataset, dataset.length);

        long startB = System.nanoTime();
        long stepsB = BubbleSort.bubbleSort(data1);
        long timeB = System.nanoTime() - startB;

        MergeSort.steps = 0;
        long startM = System.nanoTime();
        MergeSort.mergeSort(data2, 0, data2.length - 1);
        long timeM = System.nanoTime() - startM;

        QuickSort.steps = 0;
        long startQ = System.nanoTime();
        QuickSort.quickSort(data3, 0, data3.length - 1);
        long timeQ = System.nanoTime() - startQ;

        System.out.println("\n--- Performance Comparison Table ---");
        System.out.printf("%-12s %-12s %-12s%n", "Algorithm", "Steps", "Time(ns)");
        System.out.printf("%-12s %-12d %-12d%n", "BubbleSort", stepsB, timeB);
        System.out.printf("%-12s %-12d %-12d%n", "MergeSort", MergeSort.steps, timeM);
        System.out.printf("%-12s %-12d %-12d%n", "QuickSort", QuickSort.steps, timeQ);
    }
}
