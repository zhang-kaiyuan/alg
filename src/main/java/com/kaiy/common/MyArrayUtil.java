package com.kaiy.common;


import java.util.Arrays;
import java.util.function.Function;

public class MyArrayUtil {

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int[] copy(int[] src) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }

    public static void sortLogarithmic(Function<int[], int[]> f1) {
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
