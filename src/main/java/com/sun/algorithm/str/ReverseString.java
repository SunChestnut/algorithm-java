package com.sun.algorithm.str;

import java.util.Arrays;

/**
 * 题目：反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * ----------------------------------------------------------
 * 示例 1：
 * 输入: ["h","e","l","l","o"]
 * 输出: ["o","l","l","e","h"]
 * ----------------------------------------------------------
 * 示例 2：
 * 输入: ["H","a","n","n","a","h"]
 * 输出: ["h","a","n","n","a","H"]
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/18 - 21:04
 */
public class ReverseString {

    /**
     * 双指针法：left为左指针，right为右指针，开始时左指针指向首元素，右指针指向尾元素，
     * 交换两个指针所指向的元素，并向中间移动，直到两个指针相遇，遍历s.length/2次
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param s 源数组
     */
    public static void reverseString(char[] s) {
        int right = s.length - 1;
        for (int left = 0; left <= s.length / 2 - 1; left++) {
            if (right >= s.length / 2) {
                if (s[left] != s[right]) {
                    swap(s, left, right);
                }
                right--;
            }
        }

    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'v', 'o'};
        reverseString(s1);
        System.out.println(Arrays.toString(s1));

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(Arrays.toString(s2));

        char[] s3 = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ',
                'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        reverseString(s3);
        System.out.println(Arrays.toString(s3));

    }
}
