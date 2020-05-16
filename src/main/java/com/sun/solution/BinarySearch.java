package com.sun.solution;

/**
 * 704. 二分查找
 *
 * @author syl
 * @date 2020/05/08 - 10:30
 */
public class BinarySearch {

    /**
     * 二分查找模板一
     *
     * @param nums   源数组
     * @param target 目标值
     * @return 数组下标
     */
    public int searchI(int[] nums, int target) {

        int mid, l = 0, r = nums.length - 1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找模板二
     *
     * @param nums   源数组
     * @param target 目标值
     * @return 数组下标
     */
    public int searchII(int[] nums, int target) {

        int mid, l = 0, r = nums.length - 1;

        while (l < r) {
            mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (l != nums.length && nums[l] == target) {
            return l;
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        System.out.println(solution.searchI(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.searchI(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.searchI(new int[]{5}, 5));
        System.out.println(solution.searchI(new int[]{5}, 9));
        System.out.println("-------------------------------------------");
        System.out.println(solution.searchII(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.searchII(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.searchII(new int[]{5}, 5));
        System.out.println(solution.searchII(new int[]{5}, 9));
    }

}
