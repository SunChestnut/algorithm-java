package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/14 4:40 下午
 * @see com.sun.offer.simple
 */
public class Offer53I {

    public static int searchA(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static int searchB(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pivot = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
                pivot = right;
            } else {
                left = mid + 1;
            }
        }
        int count = 0;
        for (int i = pivot; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchA(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(searchB(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(searchB(new int[]{2, 2}, 1));

    }
}
