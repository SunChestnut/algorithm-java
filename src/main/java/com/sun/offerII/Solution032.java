package com.sun.offerII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2021/12/20 9:33 下午
 * @see com.sun.offerII
 */
public class Solution032 {

    /**
     * 排序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramSorted(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    /**
     * 哈希表
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            table.put(value, table.getOrDefault(value, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char value = t.charAt(i);
            table.put(value, table.getOrDefault(value, 0) - 1);
            if (table.get(value) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution032 solution = new Solution032();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "cat"));
        System.out.println(solution.isAnagram("r", "r"));

        System.out.println(solution.isAnagramSorted("anagram", "nagaram"));
        System.out.println(solution.isAnagramSorted("rat", "cat"));
        System.out.println(solution.isAnagramSorted("r", "r"));
    }

}
