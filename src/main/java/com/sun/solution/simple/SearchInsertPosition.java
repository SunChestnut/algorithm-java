package com.sun.solution.simple;

/**
 * 【简单 Solution35】
 * 题目：搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * ----------------------------------------------------------
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/04 - 14:11
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        // 判断数组中是否存在target，如果存在，返回target所在的数组下标
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        // target应放在第一个比target大的值的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                return i;
            }
        }

        // 如果前两个条件都不符合，则说明数组中没有比target大的值，target应放在数组的最后一位
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }

}
