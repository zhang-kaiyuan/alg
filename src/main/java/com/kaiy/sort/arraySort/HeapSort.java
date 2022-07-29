package com.kaiy.sort.arraySort;

import com.kaiy.common.ArrayUtil;
import com.kaiy.dataStructure.Heap;

/**
 * 堆排序
 */
public class HeapSort extends AbstractSort {

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 第一遍循环创建出一个大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            Heap.heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        ArrayUtil.swap(arr, 0, --heapSize);
        // 第二遍循环 依次将最大值向最后移动 变成有序数组
        while (heapSize > 0) {
            Heap.heapify(arr, 0, heapSize);
            ArrayUtil.swap(arr, 0, --heapSize);
        }

    }

    public static void main(String[] args) {
        sortLogarithmic(HeapSort::heapSort);
    }
}
