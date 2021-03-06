package com.kaiy.sort.arraySort;

import com.kaiy.common.ArrayUtil;
import com.kaiy.common.SamplesToGenerate;

import java.util.Arrays;

public abstract class AbstractSort {

    protected static void sortLogarithmic(Sort<int[]> fun) {
        boolean flag = true;
        for (int i = 0; i < 100000; i++) {
            int[] sample = SamplesToGenerate.generateRandomArray(true);
            int[] clone = ArrayUtil.copy(sample);
            Arrays.sort(sample);
            fun.sort(clone);
            if (!Arrays.equals(sample, clone)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "nice!" : "shit!");
    }

    @FunctionalInterface
    protected interface Sort<T> {
        void sort(T t);
    }

}
