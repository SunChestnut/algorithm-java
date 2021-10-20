package com.sun.alogorithm;

/**
 * 【使用二分法求旋转数组中的最小值系列】
 *
 * @author sunyl
 * @date 2021/10/18 8:22 下午
 * @see com.sun.alogorithm
 */
public class MinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
