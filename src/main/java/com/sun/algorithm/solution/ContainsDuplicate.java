package com.sun.algorithm.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：存在重复元素(ContainsDuplicate)
 * ----------------------------------------------------------
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * ----------------------------------------------------------
 *
 * @Author: syl
 * @Date: 2019/9/3 15:11
 **/
public class ContainsDuplicate {

    /**
     * 通过哈希表解决
     */
    static boolean containsDuplicateI(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        return numSet.size() != nums.length;
    }

    /**
     * 通过哈希表解决
     */
    static boolean containsDuplicateII(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int i : nums) {
            if (numSet.contains(i)) {
                return true;
            }
            numSet.add(i);
        }
        return false;
    }

    /**
     * 排序
     */
    static boolean containsDuplicateIII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(ContainsDuplicate.containsDuplicateIII(nums));
    }
}
