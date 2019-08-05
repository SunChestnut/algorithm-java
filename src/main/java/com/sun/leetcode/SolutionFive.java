package com.sun.leetcode;


import com.sun.model.ExampleModel;
import com.sun.util.ToolUtil;

import java.time.Instant;
import java.util.Date;

/**
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * ----------------------------------------------------------
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * ----------------------------------------------------------
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/20 17:08
 **/
class SolutionFive {

    static String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String longestPalindromeStr = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String tempStr = s.substring(i, j);
                if (isPalindromic(s)) {
                    if (tempStr.length() > maxLength) {
                        maxLength = tempStr.length();
                        longestPalindromeStr = tempStr;
                    }

                }
            }
        }
        return longestPalindromeStr;
    }

    private static boolean isPalindromic(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < n && j > 0) {
            if (j == i) {
                return true;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}

/*……*********************************
   🍟 Tips:
        考察要点： 回文 + 动态规划 + 字符串处理
 */
