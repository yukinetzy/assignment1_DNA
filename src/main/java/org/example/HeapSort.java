package org.example;

public class HeapSort {
    private final Metrics metrics;

    public HeapSort(Metrics metrics) {
        this.metrics = metrics;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;   // корень
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            metrics.incComparisons();
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            metrics.incComparisons();
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
