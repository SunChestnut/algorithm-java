package com.sun.alogorithm;

import java.util.Arrays;

/**
 * 【中等】
 *
 * @author sunyl
 * @date 2021/10/14 7:56 下午
 * @see com.sun.alogorithm
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, pivot = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                pivot = mid;
            } else {
                left = mid + 1;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
