package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {

    @Test
    void testComparisons() {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incComparisons();
        assertEquals(2, m.getComparisons());
    }

    @Test
    void testAllocations() {
        Metrics m = new Metrics();
        m.incAllocations();
        assertEquals(1, m.getAllocations());
    }

    @Test
    void testRecursionDepth() {
        Metrics m = new Metrics();
        m.enterRecursion();
        m.enterRecursion();
        m.exitRecursion();
        m.exitRecursion();
        assertEquals(2, m.getMaxDepth());
    }
}
