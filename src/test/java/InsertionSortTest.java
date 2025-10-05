import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testEmptyArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr, "Empty array should remain empty");
        assertEquals(0, sorter.getTracker().getComparisons(), "No comparisons for empty array");
        assertEquals(0, sorter.getTracker().getSwaps(), "No swaps for empty array");
        assertEquals(0, sorter.getTracker().getArrayAccesses(), "No array accesses for empty array");
    }

    @Test
    public void testSingleElement() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr, "Single-element array should remain unchanged");
        assertEquals(0, sorter.getTracker().getComparisons(), "No comparisons for single-element array");
        assertEquals(0, sorter.getTracker().getSwaps(), "No swaps for single-element array");
        assertEquals(1, sorter.getTracker().getArrayAccesses(), "Only one array access for single-element array");
    }

    @Test
    public void testAlreadySorted() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Already sorted array should remain unchanged");
        assertTrue(sorter.getTracker().getComparisons() > 0, "Comparisons should be greater than zero");
    }

    @Test
    public void testReverseSorted() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Reverse-sorted array should be sorted correctly");
        assertTrue(sorter.getTracker().getComparisons() > 0, "Comparisons should be greater than zero");
        assertTrue(sorter.getTracker().getSwaps() > 0, "Swaps should be greater than zero");
    }

    @Test
    public void testRandomArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr, "Random array should be sorted correctly");
        assertTrue(sorter.getTracker().getComparisons() > 0);
        assertTrue(sorter.getTracker().getSwaps() > 0);
    }

    @Test
    public void testDuplicates() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {4, 2, 2, 4, 3, 3, 1, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 4}, arr, "Array with duplicates should be sorted correctly");
        assertTrue(sorter.getTracker().getComparisons() > 0);
    }

    @Test
    public void testNearlySortedArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {1, 2, 3, 5, 4, 6, 7};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, arr, "Nearly sorted array should be sorted correctly");
        assertTrue(sorter.getTracker().getComparisons() > 0);
    }

    @Test
    public void testLargeRandomArray() {
        InsertionSort sorter = new InsertionSort();
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }

        int[] expected = arr.clone();
        java.util.Arrays.sort(expected);

        sorter.sort(arr);
        assertArrayEquals(expected, arr, "Large random array should be sorted correctly");
        assertTrue(sorter.getTracker().getComparisons() > 0);
        assertTrue(sorter.getTracker().getSwaps() > 0);
        assertTrue(sorter.getTracker().getArrayAccesses() > 0);
    }
}
