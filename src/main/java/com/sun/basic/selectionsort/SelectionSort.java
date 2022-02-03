package com.sun.basic.selectionsort;

import com.sun.basic.SortTestHelper;

/**
 * 【选择排序】
 *
 * @author sunyl
 * @date 2022/1/27 2:32 PM
 * @see com.sun.basic.selectionsort
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 寻找 [i,n) 区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        final int[] nums = SortTestHelper.generateRandomArray(1000, 100, 30000);
        SortTestHelper.testSort("com.sun.basic.ss.SelectionSort", nums);
    }
}
