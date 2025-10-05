package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long accesses;
    private long swaps;

    public void reset() {
        comparisons = 0;
        accesses = 0;
        swaps = 0;
    }

    public void countComparison() {
        comparisons++;
    }

    public void countAccess() {
        accesses++;
    }

    public void countSwap() {
        swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getAccesses() {
        return accesses;
    }

    public long getSwaps() {
        return swaps;
    }

    @Override
    public String toString() {
        return "Comparisons=" + comparisons +
                ", Accesses=" + accesses +
                ", Swaps=" + swaps;
    }
}
