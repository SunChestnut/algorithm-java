package com.sun.solution.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 【720. 词典中最长的单词】
 * 🔗 https://leetcode.cn/problems/longest-word-in-dictionary/
 *
 * @author sunyl
 * @date 2022/5/15 18:37
 * @see com.sun.solution.simple
 */
public class LongestWordInDictionary {

    /**
     * 【方法一】哈希集合
     *
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });

        String longest = "";
        Set<String> candidates = new HashSet<>();
        candidates.add("");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        String res = LongestWordInDictionary.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
        System.out.println(res);
    }
}
