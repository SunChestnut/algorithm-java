package com.sun.basic;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/1/24 7:04 PM
 * @see com.sun.basic
 */
public class QuickSortBetter {

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

    private static int partition(int[] nums, int l, int r) {
        // 随机化快速排序
        int rand = (int) (Math.random() * (r - l + 1)) + l;
        swap(nums, l, rand);
        int v = nums[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 6, 7, 10, 3};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
