package com.kaiy.sort.arraySort;

/**
 * 归并排序
 */
public class MergeSort extends AbstractSort {

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // 注意这边两个递归方法不能出现重合区域
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        // 注意这个边界问题 左右merge的时候注意不能重合
        int p1 = mid + 1;
        int p2 = left;
        int index = 0;
        while(p2 <= mid && p1 <= right) {
            help[index++] = arr[p2] <= arr[p1] ? arr[p2++] : arr[p1++];
        }
        while(p2 <= mid) {
            help[index++] = arr[p2++];
        }
        while(p1 <= right) {
            help[index++] = arr[p1++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        sortLogarithmic(MergeSort::mergeSort);
    }
}
