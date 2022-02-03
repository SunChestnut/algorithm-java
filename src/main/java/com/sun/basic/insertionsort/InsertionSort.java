package com.sun.basic.insertionsort;

import com.sun.basic.SortTestHelper;

/**
 * @author sunyl
 * @date 2022/1/29 10:33 AM
 * @see com.sun.basic.insertionsort
 */
public class InsertionSort {

    public static void sortLonger(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    // 因为当前元素前面的元素都是有序的，所以当当前元素大于它的前一个元素时，当前元素就已经处在合适的位置了
                    break;
                }
            }
        }
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] nums = SortTestHelper.generateRandomArray(n, 9, 9999);
        int[] copyNums = new int[n];
        System.arraycopy(nums, 0, copyNums, 0, n);
        SortTestHelper.testSort("com.sun.basic.insertionsort.InsertionSortBetter", nums);
        SortTestHelper.testSort("com.sun.basic.selectionsort.SelectionSort", copyNums);

    }
}
