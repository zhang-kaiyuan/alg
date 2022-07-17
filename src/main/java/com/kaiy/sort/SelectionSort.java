package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;

public class SelectionSort {

    private static int[] selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            MyArrayUtil.swap(array, index, i);
        }
        return array;
    }

    public static void main(String[] args) {
        MyArrayUtil.sortLogarithmic(SelectionSort::selectionSort);
    }

}
