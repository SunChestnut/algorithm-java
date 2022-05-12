package com.sun.solution.simple;

import java.util.Arrays;

/**
 * 【简单 Solution88】
 * 题目：合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * ----------------------------------------------------------
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/09 - 09:18
 */
public class MergeSortedArray {

    /**
     * 直接将nums2复制到nums1中，然后再对nums1排序
     * 时间复杂度为：O((n+m)log(n+m))
     *
     * @param nums1 nums1
     * @param m     nums1中的元素数量
     * @param nums2 nums2
     * @param n     nums2中的元素数量
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void mergeI(int[] nums1, int m, int[] nums2, int n) {
        // 设置一个nums1的拷贝数组
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        // 设置两个指针分别指向nums1Copy和nums2
        int p1 = 0;
        int p2 = 0;

        // 设置指针指向nums1
        int p = 0;

        // 分别对比nums1Copy和nums2中的每一个值，将较小的值拷贝到nums1中
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        //merge(nums1, m, nums2, n);

        mergeI(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
