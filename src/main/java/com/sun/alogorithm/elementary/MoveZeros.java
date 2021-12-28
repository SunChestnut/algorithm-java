package com.sun.alogorithm.elementary;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2021/12/28 12:08 下午
 * @see com.sun.alogorithm.elementary
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < n; ) {
                if (nums[j] == 0) {
                    j++;
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
    }

    public void moveZeroesBetter(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {9, 7, 6, 0, 5, 0};
        solution.moveZeroesBetter(nums1);
        solution.moveZeroesBetter(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

}
