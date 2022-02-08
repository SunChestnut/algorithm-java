package com.sun.basic.mergesort;

import com.sun.basic.SortTestHelper;

/**
 * @author sunyl
 * @date 2022/2/8 10:12 AM
 * @see com.sun.basic.mergesort
 */
public class MergeSortOptimizeOne {

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = nums[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                nums[k] = aux[i - l];
                i++;
            } else {
                nums[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = SortTestHelper.generateRandomArray(100000, 3, 100);
        SortTestHelper.testSort("com.sun.basic.mergesort.MergeSortOptimizeOne", nums);
    }
}
