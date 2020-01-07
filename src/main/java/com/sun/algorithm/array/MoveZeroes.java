package com.sun.algorithm.array;

import java.util.Arrays;

/**
 * 题目：移动零
 * ----------------------------------------------------------
 * 给定一个数组`nums`，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * ----------------------------------------------------------
 * 说明:
 * - 必须在原数组上操作，不能拷贝额外的数组。
 * - 尽量减少操作次数。
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2019/12/30 - 10:18
 */
public class MoveZeroes {

    /**
     * 遍历数组，将非零元素依次覆盖数组
     *
     * @param nums 待操作数组
     */
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
