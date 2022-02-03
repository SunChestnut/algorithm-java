package com.sun.basic.insertionsort;

import com.sun.basic.SortTestHelper;

/**
 * @author sunyl
 * @date 2022/1/29 2:33 PM
 * @see com.sun.basic.insertionsort
 */
public class InsertionSortBetter {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int copy = nums[i];
            int j;
            for (j = i; j > 0 && nums[j - 1] > copy; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = copy;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        int[] nums = SortTestHelper.generateNealyOrderedArray(n, 10);
        int[] copyNums = new int[n];
        System.arraycopy(nums, 0, copyNums, 0, n);
        // 当待排序数组近乎有序时，插入排序的性能要远远高于选择排序
        SortTestHelper.testSort("com.sun.basic.insertionsort.InsertionSortBetter", nums);
        SortTestHelper.testSort("com.sun.basic.selectionsort.SelectionSort", copyNums);
    }
}
