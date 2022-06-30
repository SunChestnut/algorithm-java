package com.sun.offerII;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/tvdfij/">🔗【剑指 Offer II 012. 左右两边子数组的和相等】 </a>
 *
 * @author sunyl
 * @date 2022/6/15 10:37
 * @see com.sun.offerII
 */
public class Solution012 {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution012 solution = new Solution012();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
    }
}
