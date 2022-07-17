package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;

public class SelectionSort extends AbstractSort {

    private static int[] selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
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
        sortLogarithmic(SelectionSort::selectionSort);
    }

}
