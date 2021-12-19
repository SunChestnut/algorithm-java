package com.sun.offerII;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kLl5u1/
 *
 * @author sunyl
 * @date 2021/12/8 10:06 上午
 * @see com.sun.offerII
 */
public class Solution006 {

    /**
     * 单次遍历 ➕ 二分法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int sub = target - numbers[i];
            if (i + 1 == n) {
                return new int[0];
            }
            int pivotIndex = binarySearch(numbers, i + 1, n - 1, sub);
            if (-1 != pivotIndex) {
                return new int[]{i, pivotIndex};
            }
        }
        return new int[0];
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 双指针法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumWithTwoPoint(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution006 solution = new Solution006();
        int[] numbers = new int[]{1, 2, 4, 6, 10};
        System.out.println(solution.binarySearch(numbers, 0, numbers.length - 1, 6));
        System.out.println(solution.binarySearch(numbers, 0, numbers.length - 1, 199));

        System.out.println(Arrays.toString(solution.twoSum(numbers, 8)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, 1)));

        System.out.println("##############");

        System.out.println(Arrays.toString(solution.twoSumWithTwoPoint(numbers, 8)));
        System.out.println(Arrays.toString(solution.twoSumWithTwoPoint(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSumWithTwoPoint(new int[]{-1, 0}, 1)));
    }

}
