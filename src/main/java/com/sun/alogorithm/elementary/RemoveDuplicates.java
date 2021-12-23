package com.sun.alogorithm.elementary;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2021/12/22 3:52 下午
 * @see com.sun.alogorithm.elementary
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (1 == nums.length) {
            return 1;
        }
        int res = 1;
        for (int i = 0, j = 1; i < nums.length && j < nums.length; ) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                res++;
            }
        }
        return res;
    }

    public int removeDuplicatesBetter(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        int slow = 1, faster = 1;
        while (faster < nums.length) {
            if (nums[faster] != nums[faster - 1]) {
                nums[slow] = nums[faster];
                slow++;
            }
            faster++;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] numsA = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicatesBetter(numsA));
        System.out.println(Arrays.toString(numsA));

        int[] numsB = {1, 1, 2};
        System.out.println(solution.removeDuplicatesBetter(numsB));
        System.out.println(Arrays.toString(numsB));

    }
}
