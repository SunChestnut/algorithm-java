package com.sun.offerII;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.cn/problems/aseY1I/">🔗【剑指 Offer II 005. 单词长度的最大乘积】</a>
 *
 * @author sunyl
 * @date 2022/6/14 11:07
 * @see com.sun.offerII
 */
@Slf4j
public class Solution005 {

    /**
     * 暴力破解
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!isContains(words[i].toCharArray(), words[j].toCharArray())) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    log.info("a = " + words[i] + ", b = " + words[j] + ", max = " + max);
                }

            }
        }
        return max;
    }


    private boolean isContains(char[] a, char[] b) {
        for (char i : a) {
            for (char j : b) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 优化如下
     **/

    public int maxProductOptimize(String[] words) {
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hasSameChar(words[i], words[j])) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }

            }
        }
        return max;
    }

    private boolean hasSameChar(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution005 solution = new Solution005();
        System.out.println(solution.maxProductOptimize(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"}));
        System.out.println(solution.maxProductOptimize(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(solution.maxProductOptimize(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
