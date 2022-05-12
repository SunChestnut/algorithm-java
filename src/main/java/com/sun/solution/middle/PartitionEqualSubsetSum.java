package com.sun.solution.middle;

/**
 * 【416. 分割等和子集】
 * <p>
 * 🔗 https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author sunyl
 * @date 2022/5/8 10:54
 * @see com.sun.solution.middle
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        // 如果数组长度小于 2，则无法将数组分成两个元素和相等的子集
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int v : nums) {
            sum += v;
            maxNum = Math.max(maxNum, v);
        }
        // sum 为奇数，不可能将数组分割成两个元素和相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 如果数组中的最大值 大于 整个数组和的一半，则数组的其余值的和一定 小于 整个数组和的一半，因此不可能将数据分割成两个元素和相等的子集
        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        System.out.println(canPartition(nums));
    }
}
