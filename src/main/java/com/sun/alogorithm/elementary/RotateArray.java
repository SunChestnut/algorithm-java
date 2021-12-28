package com.sun.alogorithm.elementary;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2021/12/24 10:41 上午
 * @see com.sun.alogorithm.elementary
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = tmp[i];
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};
        int[] nums3 = {1};
        solution.rotate(nums1, 3);
        solution.rotate(nums2, 2);
        solution.rotate(nums3, 2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
