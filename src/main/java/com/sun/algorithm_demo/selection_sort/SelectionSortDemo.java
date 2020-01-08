package com.sun.algorithm_demo.selection_sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 选择排序【时间复杂度O(n^2)】：
 * 1⃣️ 找出数组中的最小值元素
 * 2⃣️ 将该元素与数组中的第一个待排序元素交换位置
 *
 * @author syl
 * @date 2020/01/07 - 15:23
 */
public class SelectionSortDemo {

    /**
     * 算法类不允许产生任何实例
     */
    private SelectionSortDemo() {
    }

    public static void selectionSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int minValue = findMinValue(nums, i, nums.length - 1);
            swap(nums, i, minValue);
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 寻找[beginIndex,endIndex]区间内的最小值
     *
     * @param nums       初始数组
     * @param beginIndex 起始下标
     * @param endIndex   结束下标
     * @return 数组中的最小元素的下标
     */
    private static int findMinValue(int[] nums, int beginIndex, int endIndex) {
        int minIndex = beginIndex;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 数组内交换元素
     *
     * @param nums   初始数组
     * @param aIndex 待交换的元素下标
     * @param bIndex 待交换的元素下标
     */
    private static void swap(int[] nums, int aIndex, int bIndex) {
        int temp = nums[aIndex];
        nums[aIndex] = nums[bIndex];
        nums[bIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 2, 3, 1, 5, 7, 4};
        selectionSort(nums);
    }
}
