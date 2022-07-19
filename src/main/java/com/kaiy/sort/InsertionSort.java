package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;

public class InsertionSort extends AbstractSort {

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int l = i; l > 0; l--) {
                if (arr[l] < arr[l - 1]) {
                    MyArrayUtil.swap(arr, l, l - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        sortLogarithmic(InsertionSort::insertionSort);
    }

}
