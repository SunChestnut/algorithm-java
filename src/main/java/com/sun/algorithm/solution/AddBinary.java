package com.sun.algorithm.solution;

/**
 * 【简单 Solution67】
 * 题目：二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/07 - 09:17
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int valueA = i < 0 ? 0 : a.charAt(i--) - '0';
            int valueB = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = valueA + valueB + carry;
            builder.insert(0, Character.forDigit(sum % 2, 10));
            carry = sum / 2;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
