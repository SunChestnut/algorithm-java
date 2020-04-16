package com.sun.everyday;

/**
 * leetcode面试题 17.16. 按摩师 ❓
 *
 * @author syl
 * @date 2020/03/24 - 09:45
 */
public class TheMasseuseLCCI {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int massage(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < n; ++i) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];

            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }

    public static void main(String[] args) {
        TheMasseuseLCCI solution = new TheMasseuseLCCI();
        System.out.println(solution.massage(new int[]{1, 2, 3, 1}));
        System.out.println(solution.massage(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.massage(new int[]{1, 1}));
    }

}
