package com.kaiy.common;

import java.util.Arrays;

public class SamplesToGenerate {

    private static final int SAMPLE_SIZE = 100;
    private static final int SAMPLE_RANGE = 1000;

    public static int[] generateRandomArray(boolean negative) {
        int size = (int) (Math.random() * SAMPLE_SIZE);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int rand = (int) (Math.random() * SAMPLE_RANGE);
            array[i] = whetherToGenerateNegative(negative) ? rand : rand * -1;
        }
        return array;
    }

    private static boolean whetherToGenerateNegative(boolean negative) {
        return negative && ((int) (Math.random() * 2) & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(true)));
    }

}
