package com.sun.dailyquestion.interview56;

import java.util.Arrays;

/**
 * 面试题56 - I. 数组中数字出现的次数 ???
 *
 * @author syl
 * @date 2020/04/19 - 14:20
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {

        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
            System.out.println("nums[" + k + "] = " + nums[k] + " , xorNumber = " + xorNumber);
        }

        int onePosition = xorNumber & (-xorNumber);
        System.out.println("onePostion = " + xorNumber);
        int ans1 = 0, ans2 = 0;
        for (int v : nums) {
            if ((v & onePosition) == onePosition) {
                ans1 ^= v;
            } else {
                ans2 ^= v;
            }
        }

        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res1 = solution.singleNumbers(new int[]{4, 1, 4, 6});
        int[] res2 = solution.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));

    }

}
