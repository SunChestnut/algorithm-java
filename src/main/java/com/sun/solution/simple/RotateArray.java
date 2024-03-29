package com.sun.solution.simple;

/**
 * 题目：旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * ----------------------------------------------------------
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * ----------------------------------------------------------
 *
 * @Author: syl
 * @Date: 2019/8/22 15:47
 **/
class RotateArray {

    /**
     * 暴力法
     * 旋转k次，每次旋转一个元素
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(1)。没有使用额外的空间
     */
    static void rotateI(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 使用额外的数组
     * 使用额外的数组将每个元素放到正确的位置上，也就是原本数组里下标为i的把它放到 (i + k)%数组长度 的位置。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    static void rotateII(int[] nums, int k) {
        int n = nums.length;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = (i + k) % n;
            newNums[(i + k) % n] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, n);
    }

}
