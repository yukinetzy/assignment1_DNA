package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSmallArray() {
        Metrics metrics = new Metrics();
        QuickSort quickSort = new QuickSort(metrics);

        int[] arr = {5, 1, 4, 2, 8};
        quickSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arr);
    }

    @Test
    void testAlreadySorted() {
        Metrics metrics = new Metrics();
        QuickSort quickSort = new QuickSort(metrics);

        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        Metrics metrics = new Metrics();
        QuickSort quickSort = new QuickSort(metrics);

        int[] arr = {9, 7, 5, 3, 1};
        quickSort.sort(arr);

        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    void testLargeRandomArray() {
        Metrics metrics = new Metrics();
        QuickSort quickSort = new QuickSort(metrics);

        int[] arr = new java.util.Random().ints(1000, 0, 10000).toArray();
        int[] copy = Arrays.copyOf(arr, arr.length);

        quickSort.sort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }
}
