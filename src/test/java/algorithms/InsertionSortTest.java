package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testEmptyArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
        assertEquals(0, sorter.getTracker().getAccesses());
    }

    @Test
    public void testSingleElement() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
        assertEquals(1, sorter.getTracker().getAccesses(), "Single element should trigger 1 access");
    }

    @Test
    public void testAlreadySorted() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    public void testDuplicates() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {4, 2, 2, 4, 3, 3, 1, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 4}, arr);
    }

    @Test
    public void testNearlySortedArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {1, 2, 3, 5, 4, 6, 7};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, arr);
    }

    @Test
    public void testLargeRandomArray() {
        InsertionSort sorter = new InsertionSort();
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * 10000);

        int[] expected = arr.clone();
        java.util.Arrays.sort(expected);

        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
