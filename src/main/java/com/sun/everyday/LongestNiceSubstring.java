package com.sun.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 【1763. 最长的美好子字符串】
 * 🔗 https://leetcode-cn.com/problems/longest-nice-substring/
 *
 * @author sunyl
 * @date 2022/2/2 10:48 AM
 * @see com.sun.everyday
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int curLen = j - i + 1;
                boolean sub = check(s.substring(i, j + 1));
                if (curLen > ans.length() && sub) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    private boolean check(String s) {
        Set<Character> memo = new HashSet<>();
        for (Character c : s.toCharArray()) {
            memo.add(c);
        }
        for (Character c : s.toCharArray()) {
            char lower = Character.toLowerCase(c), upper = Character.toUpperCase(c);
            if (!memo.contains(lower) || !memo.contains(upper)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestNiceSubstring solution = new LongestNiceSubstring();
        System.out.println(solution.longestNiceSubstring("YazaAay"));
    }

}
