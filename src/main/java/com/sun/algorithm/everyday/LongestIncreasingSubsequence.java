package com.sun.algorithm.everyday;

/**
 * leetcode300. 最长上升子序列
 *
 * @author syl
 * @date 2020/03/14 - 09:17
 */
public class LongestIncreasingSubsequence {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {

            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums1));
    }
}
