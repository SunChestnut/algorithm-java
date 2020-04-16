package com.sun.solution;

/**
 * leetcode 747. 至少是其他数字两倍的最大数
 * 【简单】
 *
 * @author syl
 * @date 2020/04/16 - 09:03
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int n = nums.length;

        // 找出数组的最大值，及最大值的索引值
        int bigNum = Integer.MIN_VALUE;
        int finalIndex = 0;
        for (int i = 0; i < n; i++) {
            if (bigNum < nums[i]) {
                bigNum = nums[i];
                finalIndex = i;
            }
        }

        // 判断是否符合条件
        for (int v : nums) {
            if (bigNum != v && bigNum < v * 2) {
                return -1;
            }
        }

        return finalIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        LargestNumberAtLeastTwiceOfOthers solution = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(solution.dominantIndex(nums));
    }

}
