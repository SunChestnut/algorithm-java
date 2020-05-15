package com.sun.solution;

/**
 * 33. 搜索旋转排序数组
 *
 * @author syl
 * @date 2020/05/15 - 08:28
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int n = nums.length;

        // 当数组为空时
        if (n == 0) {
            return -1;
        }

        // 当数组内只有一个元素时
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int mid, left = 0, right = n - 1;
        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断 nums[0]~nums[mid] 是否是递增的
            if (nums[0] <= nums[mid]) {
                // 判断 target 是否在当前递增区间内
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{}, 5));
        System.out.println(solution.search(new int[]{1, 3}, 3));
    }
}
