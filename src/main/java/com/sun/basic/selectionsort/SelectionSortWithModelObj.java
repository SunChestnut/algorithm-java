package com.sun.basic.selectionsort;

/**
 * 使用模板类改写选择排序算法
 *
 * @author sunyl
 * @date 2022/1/27 3:23 PM
 * @see com.sun.basic.selectionsort
 */
public class SelectionSortWithModelObj {

    public static void sort(Comparable[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 寻找 [i,n) 区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j].compareTo(nums[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(Object[] nums, int i, int j) {
        Object tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
    }
}
