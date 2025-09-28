package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterministicSelectTest {

    private final Metrics metrics = new Metrics();
    private final DeterministicSelect selector = new DeterministicSelect(metrics);

    @Test
    void testSmallArraysAndInvalidK() {
        assertEquals(42, selector.select(new int[]{42}, 0));
        assertThrows(IllegalArgumentException.class, () -> selector.select(new int[]{}, 0));
        assertThrows(IllegalArgumentException.class, () -> selector.select(new int[]{1, 2, 3}, -1));
        assertThrows(IllegalArgumentException.class, () -> selector.select(new int[]{1, 2, 3}, 3));
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(1, selector.select(arr, 0));
        assertEquals(3, selector.select(arr, 2));
        assertEquals(5, selector.select(arr, 4));
    }

    @Test
    void testReverseArray() {
        int[] arr = {9, 7, 5, 3, 1};
        assertEquals(1, selector.select(arr, 0));
        assertEquals(5, selector.select(arr, 2));
        assertEquals(9, selector.select(arr, 4));
    }

    @Test
    void testRandomArray() {
        int[] arr = {12, 3, 7, 4, 19, 8};
        assertEquals(3, selector.select(arr, 0));
        assertEquals(7, selector.select(arr, 2));
        assertEquals(19, selector.select(arr, 5));
    }
}
