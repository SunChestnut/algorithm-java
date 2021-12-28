package com.sun.alogorithm.elementary;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2021/12/27 10:16 上午
 * @see com.sun.alogorithm.elementary
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return res;
    }

    /**
     * XOR : 异或运算
     *
     * @param nums
     * @return
     */
    public int singleNumberWithXor(int[] nums) {
        int res = 0;
        for (int tmp : nums) {
            res ^= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));

        System.out.println(solution.singleNumberWithXor(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumberWithXor(new int[]{4, 1, 2, 1, 2}));
    }
}
