package org.example;

import java.util.Arrays;

public class DeterministicSelect {
    private final Metrics metrics;

    public DeterministicSelect(Metrics metrics) {
        this.metrics = metrics;
    }


    public int select(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        return select(arr, 0, arr.length - 1, k);
    }

    private int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) {
                return arr[left];
            }

            int pivotIndex = medianOfMedians(arr, left, right);

            pivotIndex = partition(arr, left, right, pivotIndex);

            if (k == pivotIndex) {
                return arr[k];
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            metrics.incComparisons();
            if (arr[i] < pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return left + n / 2;
        }

        int numMedians = 0;
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            Arrays.sort(arr, i, subRight + 1);
            int median = i + (subRight - i) / 2;
            swap(arr, left + numMedians, median);
            numMedians++;
        }

        return medianOfMedians(arr, left, left + numMedians - 1);
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
