package com.sun.solution;

/**
 * 704. 二分查找
 *
 * @author syl
 * @date 2020/05/08 - 10:30
 */
public class BinarySearch {

    /**
     * 二分查找模板一：用于查找可以通过访问数组中的单个索引来确定的元素或条件
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
     * 二分查找模板二：用于查找访问数组中 当前索引 及其 直接右邻居索引的
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

    /**
     * 二分查找模板三：用于搜索需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件
     *
     * @param nums   源数组
     * @param target 目标值
     * @return 数组下标
     */
    public int searchIII(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }

}
