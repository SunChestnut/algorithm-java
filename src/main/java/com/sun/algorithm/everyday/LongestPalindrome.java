package com.sun.algorithm.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/19 - 11:18
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int otherSolution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            ans += v / 2 * 2;

            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome("abccccdd"));

        System.out.println(solution.otherSolution("abccccdd"));
    }
}
