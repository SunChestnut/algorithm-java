package com.sun.algorithm.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。（请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。）
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/18 17:31
 **/
class SolutionThree {

    /*……********************* 方法一：暴力法 *********************……*/

    static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }

        }
        return ans;
    }

    /**
     * 判断子字符串中的字符是否都是唯一的
     *
     * @param s     子字符串
     * @param start 子字符串的起始位置
     * @param end   子字符串的终止位置
     * @return 是否唯一
     */
    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }


    /*……******************** 方法二：滑动窗口 *********************……*/

    /**
     * 滑动窗口模式
     *
     * @param s 初始字符串
     * @return 最长无重复字串的长度
     */
    static int slidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    /*……******************** 方法三：优化的滑动窗口 *********************……*/

    /**
     * 优化的滑动窗口模式
     *
     * @param s 初始字符串
     * @return 最长无重复字串的长度
     */
    static int slidingWindowBetter(String s) {
        int n = s.length(), maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }


}
