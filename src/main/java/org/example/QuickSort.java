package org.example;

import java.util.Random;

public class QuickSort {
    private final Metrics metrics;
    private final Random random = new Random();

    public QuickSort(Metrics metrics) {
        this.metrics = metrics;
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        while (left < right) {
            metrics.enterRecursion();
            try {
                int pivotIndex = partition(arr, left, right);

                //  (bounded stack)
                if (pivotIndex - left < right - pivotIndex) {
                    quickSort(arr, left, pivotIndex - 1);
                    left = pivotIndex + 1;
                } else {
                    quickSort(arr, pivotIndex + 1, right);
                    right = pivotIndex - 1;
                }
            } finally {
                metrics.exitRecursion();
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            metrics.incComparisons();
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
