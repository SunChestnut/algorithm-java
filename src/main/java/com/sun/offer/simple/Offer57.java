package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2022/1/14 12:07 PM
 * @see com.sun.offer.simple
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            long sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return null;
    }

}
