package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker;

    public InsertionSort() {
        this.tracker = new PerformanceTracker();
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }

    public void sort(int[] array) {
        tracker.reset();
        int n = array.length;

        if (n <= 1) {
            if (n == 1) {
                tracker.countAccess();
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            int key = array[i];
            tracker.countAccess();
            int j = i - 1;

            while (j >= 0) {
                tracker.countComparison();
                tracker.countAccess();
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    tracker.countAccess();
                    tracker.countSwap();
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;
            tracker.countAccess();
        }
    }

    public static void printArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
