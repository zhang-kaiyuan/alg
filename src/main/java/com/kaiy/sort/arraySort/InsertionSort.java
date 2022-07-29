package com.kaiy.sort.arraySort;

import com.kaiy.common.ArrayUtil;

/**
 * 插入排序
 */
public class InsertionSort extends AbstractSort {

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int l = i; l > 0; l--) {
                if (arr[l] < arr[l - 1]) {
                    ArrayUtil.swap(arr, l, l - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        sortLogarithmic(InsertionSort::insertionSort);
    }

}
