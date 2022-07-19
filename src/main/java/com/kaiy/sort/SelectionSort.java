package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;

public class SelectionSort extends AbstractSort {

    private static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
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
    }

    public static void main(String[] args) {
        sortLogarithmic(SelectionSort::selectionSort);
    }

}
