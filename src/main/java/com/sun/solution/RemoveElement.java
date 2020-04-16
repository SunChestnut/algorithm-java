package com.sun.solution;

import java.util.Arrays;

/**
 * 【简单 Solution27】
 * 题目：移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * ----------------------------------------------------------
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * ----------------------------------------------------------
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/03 - 08:51
 */
public class RemoveElement {

    /**
     * 双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 源数组
     * @param val  带比较的数值
     * @return 数组长度
     */
    public static int removeElement(int[] nums, int val) {
        // 设置 i 为慢指针, j 为快指针
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 双指针法（当数组中待移出元素较少时）：当nums[i] == val 时，仅将nums[i]和最后一个元素进行交换
     *
     * @param nums 源数组
     * @param val  带比较的数值
     * @return 数组长度
     */
    public static int removeElementI(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement(nums, 2);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {4, 1, 2, 3, 5};
        int result2 = removeElementI(nums2, 4);
        System.out.println(result2);
        System.out.println(Arrays.toString(nums2));
    }
}
