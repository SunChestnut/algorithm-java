package com.sun.solution.middle;

/**
 * TODO
 *
 * @author sunyl
 * @date 2022/5/13 15:20
 * @see com.sun.solution.middle
 */
public class Algorithm123Pattern {

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int k = j + 1;
                while (k < n) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]) {
                        return true;
                    }
                    k++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Algorithm123Pattern.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }
}
