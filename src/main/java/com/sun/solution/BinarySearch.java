package com.sun.solution;

/**
 * 704. 二分查找
 *
 * @author syl
 * @date 2020/05/08 - 10:30
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

        int pivot, l = 0, r = nums.length - 1;

        while (l <= r) {
            pivot = l + (r - l) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[pivot] > target) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
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
