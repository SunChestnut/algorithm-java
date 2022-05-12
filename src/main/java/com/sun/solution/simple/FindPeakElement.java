package com.sun.solution.simple;

/**
 * 162. 寻找峰值
 *
 * @author syl
 * @date 2020/05/17 - 20:14
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // 处在下坡时，峰值可能出现在左侧
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution.findPeakElement(new int[]{2, 1}));
    }
}
