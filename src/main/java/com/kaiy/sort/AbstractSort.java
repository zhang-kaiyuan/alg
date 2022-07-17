package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;
import com.kaiy.common.SamplesToGenerate;

import java.util.Arrays;
import java.util.function.Function;

public abstract class AbstractSort {

    protected static void sortLogarithmic(Function<int[], int[]> f1) {
        boolean flag = true;
        for (int i = 0; i < 100000; i++) {
            int[] sample = SamplesToGenerate.generateRandomArray(true);
            int[] clone = MyArrayUtil.copy(sample);
            Arrays.sort(sample);
            f1.apply(clone);
            if (!Arrays.equals(sample, clone)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "nice!" : "shit!");
    }

}
