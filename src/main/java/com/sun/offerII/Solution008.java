package com.sun.offerII;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.cn/problems/2VG8Kg/">🔗【剑指 Offer II 008. 和大于等于 target 的最短子数组】</a>
 *
 * @author sunyl
 * @date 2022/6/27 15:14
 * @see com.sun.offerII
 */
@Slf4j
public class Solution008 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int len = Integer.MAX_VALUE, sum = 0;
        int start = 0, end = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                len = Math.min(len, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        Solution008 solution = new Solution008();
        log.info("Res = " + solution.minSubArrayLen(5, new int[]{1, 2, 3, 1, 1, 3}) + " Right = " + 2);
        log.info("Res = " + solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) + " Right = " + 2);
        log.info("Res = " + solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}) + " Right = " + 3);
        log.info("Res = " + solution.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}) + " Right = " + 5);
        log.info("Res = " + solution.minSubArrayLen(4, new int[]{1, 4, 4}) + " Right = " + 1);
    }
}
