package com.sun.basic.mergesort;

import com.sun.basic.SortTestHelper;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/2/7 3:47 PM
 * @see com.sun.basic.mergesort
 */
public class MergeSort {

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 递归使用归并排序，对 arr[l...r] 的范围进行排序
     *
     * @param nums
     * @param l
     * @param r
     */
    private static void mergeSort(int[] nums, int l, int r) {
        // 处理递归到底的情况
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    /**
     * 对 arr[l...mid] 和 arr[mid+1...r] 两部分进行合并
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] nums, int l, int mid, int r) {
        // 辅助的空间，aux -> auxiliary
        int[] aux = new int[r - l + 1];

        // 初始化辅助空间的值，aux 数组从索引 0 开始赋值，但 nums 数组从 l 开始遍历，所以赋值时需要设置 i-l 的偏移量
        for (int i = l; i <= r; i++) {
            aux[i - l] = nums[i];
        }

        // 索引 i 和 j 分别指向 mid 指针左右两侧的首个元素
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
        SortTestHelper.testSort("com.sun.basic.mergesort.MergeSort", nums);
        System.out.println(Arrays.toString(nums));
    }
}
