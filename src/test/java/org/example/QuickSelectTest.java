package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {

    @Test
    void testFindKthSmallest() {
        int[] arr = {7, 10, 4, 3, 20, 15};

        assertEquals(3, QuickSelect.findKthSmallest(arr.clone(), 0));
        assertEquals(4, QuickSelect.findKthSmallest(arr.clone(), 1));
        assertEquals(7, QuickSelect.findKthSmallest(arr.clone(), 2));
        assertEquals(10, QuickSelect.findKthSmallest(arr.clone(), 3));
        assertEquals(15, QuickSelect.findKthSmallest(arr.clone(), 4));
        assertEquals(20, QuickSelect.findKthSmallest(arr.clone(), 5));
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, QuickSelect.findKthSmallest(arr, 0));
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-5, -10, 0, 7, -3};
        assertEquals(-10, QuickSelect.findKthSmallest(arr.clone(), 0));
        assertEquals(-5, QuickSelect.findKthSmallest(arr.clone(), 1));
        assertEquals(7, QuickSelect.findKthSmallest(arr.clone(), 4));
    }


    @Test
    void testAllEqual() {
        int[] arr = {5, 5, 5, 5, 5};
        for (int k = 0; k < arr.length; k++) {
            assertEquals(5, QuickSelect.findKthSmallest(arr.clone(), k));
        }
    }

    @Test
    void testOutOfBounds() {
        int[] arr = {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> QuickSelect.findKthSmallest(arr, -1));
        assertThrows(IllegalArgumentException.class, () -> QuickSelect.findKthSmallest(arr, 5));
    }
}
