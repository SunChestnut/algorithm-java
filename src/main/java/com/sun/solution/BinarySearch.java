package com.sun.solution;

/**
 * 704. 二分查找
 *
 * @author syl
 * @date 2020/05/08 - 10:30
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

        int n = nums.length;

        int left = 0, right = n - 1, mid = n / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.search(new int[]{5}, 5));
        System.out.println(solution.search(new int[]{5}, 9));
    }

}
