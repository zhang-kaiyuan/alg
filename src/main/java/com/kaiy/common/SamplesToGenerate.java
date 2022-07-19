package com.kaiy.common;

public class SamplesToGenerate {

    private SamplesToGenerate() {
    }

    private static final int SAMPLE_SIZE = 100;
    private static final int SAMPLE_RANGE = 1000;

    public static int[] generateRandomArray(boolean negative) {
        int size = MyArrayUtil.randomInt(SAMPLE_SIZE);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int rand = MyArrayUtil.randomInt(SAMPLE_RANGE);
            array[i] = whetherToGenerateNegative(negative) ? rand : rand * -1;
        }
        return array;
    }

    private static boolean whetherToGenerateNegative(boolean negative) {
        return negative && (MyArrayUtil.randomInt(2) & 1) == 1;
    }

}
