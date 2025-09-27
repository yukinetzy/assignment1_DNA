package org.example;

public class MergeSort {

    private final Metrics metrics;

    public MergeSort(Metrics metrics) {
        this.metrics = metrics;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        metrics.incAllocations();
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] buffer, int left, int right) {
        metrics.enterRecursion();
        try {
            if (left >= right) return;

            int mid = left + (right - left) / 2;
            mergeSort(arr, buffer, left, mid);
            mergeSort(arr, buffer, mid + 1, right);
            merge(arr, buffer, left, mid, right);
        } finally {


            metrics.exitRecursion();
        }
    }

    private void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            metrics.incComparisons();
            if (arr[i] <= arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            buffer[k++] = arr[i++];
        }

        while (j <= right) {
            buffer[k++] = arr[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = buffer[idx];
        }
    }
}
