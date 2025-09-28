package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    public void testHeapSortBasic() {
        Metrics metrics = new Metrics();
        HeapSort heapSort = new HeapSort(metrics);

        int[] arr = {4, 10, 3, 5, 1};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{1, 3, 4, 5, 10}, arr);
    }

    @Test
    public void testHeapSortEmptyArray() {
        Metrics metrics = new Metrics();
        HeapSort heapSort = new HeapSort(metrics);

        int[] arr = {};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testHeapSortSingleElement() {
        Metrics metrics = new Metrics();
        HeapSort heapSort = new HeapSort(metrics);

        int[] arr = {42};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testHeapSortAlreadySorted() {
        Metrics metrics = new Metrics();
        HeapSort heapSort = new HeapSort(metrics);

        int[] arr = {1, 2, 3, 4, 5};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testHeapSortReverseOrder() {
        Metrics metrics = new Metrics();
        HeapSort heapSort = new HeapSort(metrics);

        int[] arr = {5, 4, 3, 2, 1};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}
