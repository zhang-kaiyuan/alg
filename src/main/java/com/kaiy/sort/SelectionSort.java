package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;
import com.kaiy.common.SamplesToGenerate;

import java.util.Arrays;

public class SelectionSort {

    private static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
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
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 100000; i++) {
            int[] sample = SamplesToGenerate.generateRandomArray(true);
            int[] clone = MyArrayUtil.copy(sample);
            Arrays.sort(sample);
            selectionSort(clone);
            if (!Arrays.equals(sample, clone)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "nice!" : "shit!");

    }

}
