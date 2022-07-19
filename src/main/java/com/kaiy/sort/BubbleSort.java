package com.kaiy.sort;

import com.kaiy.common.MyArrayUtil;

public class BubbleSort extends AbstractSort {

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 注意这里的边界条件 很容易错
        // 将外层的i想成对于N的控制 每经历一次遍历 最大值就到N-1 下一次到N-1 直到1
        // 内存需要两两比较交换 所以从1开始 j和j-1比较
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[j - 1]) {
                    MyArrayUtil.swap(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        sortLogarithmic(BubbleSort::bubbleSort);
    }

}
