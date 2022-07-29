package com.kaiy.sort.arraySort;

import com.kaiy.common.ArrayUtil;
import com.kaiy.common.IntUtil;

/**
 * 快排
 */
public class QuickSort extends AbstractSort {

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        // 注意这边条件控制好 不然栈内存溢出
        if (left >= right) {
            return;
        }
        ArrayUtil.swap(arr, left + IntUtil.randomInt(right - left + 1), right);
        int[] equalArea = partition(arr, left, right);
        sort(arr, left, equalArea[0] - 1);
        sort(arr, equalArea[1] + 1, right);
    }

    /**
     * 其中less边界的划分很难想到 在赋值时取的left - 1 在返回时使用left + 1
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] partition(int[] arr, int left, int right) {
        // 不正确的参数 直接返回异常数组
        if (left > right) {
            return new int[]{-1, -1};
        }
        // 相等的话 左右边界还是他们两个
        if (left == right) {
            return new int[]{left, right};
        }
        int less = left - 1; // 左区域边界
        int more = right; // 先让R出去 也就是将arr[R]当作比较值
        int index = left;
        while (index < more) {
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                ArrayUtil.swap(arr, index++, ++less);
            } else {
                // 这边是--more 不是more-- 理解为当前高位指针不变 前一位去交换
                ArrayUtil.swap(arr, index, --more);
            }
        }
        // 首先上面一直以R为样本 将R放入正确位置 其次more的第一个数移动到后面也是正确的
        ArrayUtil.swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        sortLogarithmic(QuickSort::quickSort);
    }
}
