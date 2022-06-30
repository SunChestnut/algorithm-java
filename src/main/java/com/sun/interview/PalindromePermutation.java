package com.sun.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 【面试题 01.04. 回文排列】
 * <p>
 * 🔗 https://leetcode.cn/problems/palindrome-permutation-lcci/
 *
 * @author sunyl
 * @date 2022/5/22 10:46
 * @see com.sun.interview
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> memo = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            memo.put(s.charAt(i), memo.getOrDefault(s.charAt(i), 0) + 1);
        }
        int check = 0;
        for (int value : memo.values()) {
            if (value % 2 == 1) {
                if (++check > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
