package com.sun.solution;

import java.util.Arrays;

/**
 * 题目： 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,3]
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/08 - 08:04
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        return add(digits, 1);
    }

    public static int[] add(int[] digits, int num) {
        int c = num;

        for (int i = digits.length - 1; i > 0; i--) {
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }

        if (c > 0) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[0] = c;
            return temp;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));

        int[] digitsT = new int[]{4, 3, 9, 9};
        System.out.println(Arrays.toString(plusOne(digitsT)));

        int[] digitsC = new int[]{0};
        System.out.println(Arrays.toString(plusOne(digitsC)));

    }
}
