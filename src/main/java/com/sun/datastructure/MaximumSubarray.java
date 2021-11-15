package com.sun.datastructure;

/**
 * @author sunyl
 * @date 2021/11/4 2:39 下午
 * @see com.sun.datastructure
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int tmpSum = 0, greatestSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (tmpSum <= 0) {
                tmpSum = num;
            } else {
                tmpSum += num;
            }
            greatestSum = Math.max(tmpSum, greatestSum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{0}));
        System.out.println(maxSubArray(new int[]{-1}));
    }
}
