package com.kaiy.dataStructure;

import com.kaiy.common.ArrayUtil;

public class Heap {

    private Heap() {
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtil.swap(arr, index, (index -1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 左子节点和右子节点取最大值 注意这边还有一个判断left + 1 不超过size
            int maxIndex = left + 1 >= heapSize || arr[left] > arr[left + 1] ? left : left + 1;
            maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;

            if (maxIndex == index) {
                break;
            }
            ArrayUtil.swap(arr, index, maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

}
