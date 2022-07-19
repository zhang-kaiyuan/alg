package com.kaiy.sort;

public class HeapSort extends AbstractSort {

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

    }

    public static void main(String[] args) {
        sortLogarithmic(HeapSort::heapSort);
    }
}
