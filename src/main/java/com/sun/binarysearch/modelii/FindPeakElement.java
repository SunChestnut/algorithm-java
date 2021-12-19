package com.sun.binarysearch.modelii;

/**
 * @author sunyl
 * @date 2021/12/9 10:41 上午
 * @see com.sun.binarysearch.modelii
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
    }

}
