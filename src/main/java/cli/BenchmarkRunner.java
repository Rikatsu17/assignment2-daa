package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import java.util.Arrays;
import java.util.Random;


public class BenchmarkRunner {

    private static final int[] N_SIZES = {100, 1000, 10000, 100000};
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println("Testing N_SIZES: " + Arrays.toString(N_SIZES) + "\n");

        for (int n : N_SIZES) {
            runBenchmarksForSize(n);
            System.out.println("---------------------------------------------------");
        }
    }


    private static void runBenchmarksForSize(int n) {
        System.out.println("TESTING WITH N = " + n + "...");

        int[] randomArr = generateRandomArray(n);
        runSingleTest(randomArr, "Random Data (Average Case)");

        int[] sortedArr = generateSortedArray(n);
        runSingleTest(sortedArr, "Sorted Data (Best Case)");

        int[] reverseArr = generateReverseSortedArray(n);
        runSingleTest(reverseArr, "Reverse Sorted Data (Worst Case)");

        int[] nearlySortedArr = generateNearlySortedArray(n);
        runSingleTest(nearlySortedArr, "Nearly Sorted Data (Optimization Test)");
    }


    private static void runSingleTest(int[] array, String label) {
        InsertionSort sorter = new InsertionSort();

        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();

        PerformanceTracker tracker = sorter.getTracker();
        long executionTimeMs = (endTime - startTime) / 1_000_000;

        boolean isSorted = isArraySorted(array);

        System.out.printf("  - Input Type: %s\n", label);
        System.out.printf("      Time elapsed (ms): %,d\n", executionTimeMs);
        System.out.printf("      %s\n", tracker.toString());
        if (!isSorted) {
            System.err.println("!!! ERROR: Array was not sorted correctly. !!!");
        }
    }

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = RAND.nextInt(n * 2);
        }
        return arr;
    }

    private static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generateReverseSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - 1 - i;
        }
        return arr;
    }

    private static int[] generateNearlySortedArray(int n) {
        int[] arr = generateSortedArray(n);
        int swapsToPerform = Math.max(1, (int)(n * 0.001));

        for (int i = 0; i < swapsToPerform; i++) {
            int idx1 = RAND.nextInt(n);
            int idx2 = RAND.nextInt(n);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    private static boolean isArraySorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
