package com.kaiy.common;


import java.util.Random;

public class MyArrayUtil {

    private MyArrayUtil() {
    }

    private static final Random random = new Random();

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

    public static int randomInt(int limit) {
        return random.nextInt(limit);
    }

}
