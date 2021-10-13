package com.sun.solution;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author syl
 * @date 2020/05/19 - 14:44
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int l = 0, r = n - 1;

        if (nums[r] > nums[l]) {
            return nums[l];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // 满足条件
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // 判断nums[0...mid]是否是递增数列
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(solution.findMin(new int[]{2,1}));
    }

}
