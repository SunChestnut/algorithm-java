package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/14 6:29 下午
 * @see com.sun.offer.simple
 */
public class Offer53II {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 1; i < n && j < n; i++, j++) {
            if (nums[j] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return 0;
    }

    public static int bar(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{0, 1, 3}));
//        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
//
        System.out.println(missingNumber(new int[0]));
        System.out.println(bar(new int[0]));
    }
}
