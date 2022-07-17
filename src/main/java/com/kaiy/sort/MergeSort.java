package com.kaiy.sort;

public class MergeSort extends AbstractSort {

    private static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        // 注意这边两个递归方法不能出现重合区域
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        // 注意这个边界问题 左右merge的时候注意不能重合
        int p1 = mid + 1;
        int p2 = L;
        int index = 0;
        while(p2 <= mid && p1 <= R) {
            help[index++] = arr[p2] <= arr[p1] ? arr[p2++] : arr[p1++];
        }
        while(p2 <= mid) {
            help[index++] = arr[p2++];
        }
        while(p1 <= R) {
            help[index++] = arr[p1++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        sortLogarithmic(MergeSort::mergeSort);
    }
}
