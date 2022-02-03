package com.sun.basic.quicksort;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/1/24 4:16 PM
 * @see com.sun.basic
 */
public class QuickSortWithRecur {

    public static void quickSort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, 0, p - 1);
        quickSort(nums, p + 1, r);
    }

    /**
     * 对 arr[l...r] 部分进行 partition 操作
     * 返回 p，使得 arr[l...p-1] < arr[p], arr[p+1...r] > arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        // arr[l + 1...j] < v, arr[j+1...r] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= v) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 3, 1, 5, 7, 8};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
