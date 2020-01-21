package com.sun.algorithm.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 【简单 Solution242】
 * 题目：有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * ----------------------------------------------------------
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * ----------------------------------------------------------
 * 注意事项：您可以假定该字符串只包含小写字母。
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/21 - 18:42
 */
public class ValidAnagram {

    /**
     * 字母异位词指字母相同，但排列不同的字符串
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否是「有效的子母异位词」
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>(16);
        Map<Character, Integer> tMap = new HashMap<>(16);
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!sMap.containsKey(entry.getKey())) {
                return false;
            }
            if (sMap.containsKey(entry.getKey()) && !sMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用一个计数器计算字符串s中每个字母出现的频率，
     * 用t减少计数器表中每个字母的计数器，通过检查计数器是否全部归零即可得出答案
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否是「有效的子母异位词」
     */
    public static boolean isAnagramT(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram(s, t));

        System.out.println(isAnagramT(s, t));

        System.out.println('b' - 'a');
    }
}
