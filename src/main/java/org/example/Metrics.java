package org.example;

public class Metrics {
    private long comparisons = 0;
    private long allocations = 0;
    private int maxDepth = 0;

    private final ThreadLocal<Integer> currentDepth = ThreadLocal.withInitial(() -> 0);

    public void incComparisons() {
        comparisons++;
    }

    public void incAllocations() {
        allocations++;
    }

    public void enterRecursion() {
        int depth = currentDepth.get() + 1;
        currentDepth.set(depth);
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public void exitRecursion() {
        currentDepth.set(currentDepth.get() - 1);
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getAllocations() {
        return allocations;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void reset() {
        comparisons = 0;
        allocations = 0;
        maxDepth = 0;
        currentDepth.set(0);
    }
}
