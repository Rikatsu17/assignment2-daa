

public class PerformanceTracker {
    private int comparisons;
    private int swaps;
    private int arrayAccesses;

    public PerformanceTracker() {
        reset();
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

    public void countComparison() { comparisons++; }
    public void countSwap() { swaps++; }
    public void countAccess() { arrayAccesses++; }

    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
    public int getArrayAccesses() { return arrayAccesses; }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons +
                ", Swaps: " + swaps +
                ", Array Accesses: " + arrayAccesses;
    }
}
