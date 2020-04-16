package com.sun.solution;

/**
 * 【简单 Solution28】
 * 题目：实现 strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/26 - 09:21
 */
public class ImplementStrstr {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        final int n = haystack.length() - needle.length() + 1;
        for (int i = 0; i < n; i++) {
            int j = i;
            int k = 0;
            while (j < haystack.length() && k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
            }
            if (k == needle.length()) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }
}
