package com.sun.offerII;

/**
 * <a href="https://leetcode.cn/problems/QTMn0o/">🔗【剑指 Offer II 010. 和为 k 的子数组】</a>
 *
 * @author sunyl
 * @date 2022/6/29 17:29
 * @see com.sun.offerII
 */
public class Solution010 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution010 solution = new Solution010();
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution.subarraySum(new int[]{1, -1, 0}, 0));
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
