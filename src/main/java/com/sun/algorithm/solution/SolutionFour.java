package com.sun.algorithm.solution;

import java.util.Arrays;

/**
 * 题目：给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * ----------------------------------------------------------
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * ----------------------------------------------------------
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/19 15:13
 **/
class SolutionFour {

    /**
     * 解题思路：
     * 1.合并两个参数数组
     * 2.将合并后的数组排序
     * 3.求出合并后的数组长度，判断长度是奇数还是偶数
     * 4.若是偶数：求中间两个值的和并除以2
     * 5.若是奇数：直接返回最中间的数
     */
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        if (nums1.length >= 1) {
            System.arraycopy(nums1, 0, nums, 0, nums1.length);
        }
        if (nums2.length >= 1) {
            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        }

        Arrays.sort(nums);

        double result;
        int middleLength = nums.length / 2;
        if (nums.length % 2 == 0) {
            int total = nums[middleLength] + nums[middleLength - 1];
            result = (double) total / 2;
        } else {
            result = nums[middleLength];
        }
        return result;
    }


    /*……*********************************
     * public static native void arraycopy(Object src,
     *                                     int  srcPos,
     *                                     Object dest,
     *                                     int destPos,
     *                                     int length);
     *
     * src: 源数组
     * srcPos: 源数组要复制的起始位置
     * dest: 目的数组
     * destPos: 目的数组放置的起始位置
     * length: 复制的长度
     */

}
