package com.sun.algorithm.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 【简单 Solution387】
 * 题目：字符串中的第一个唯一字符(First Unique Character in a String)
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * ----------------------------------------------------------
 * 案例：
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * ----------------------------------------------------------
 * 注意事项：您可以假定该字符串只包含小写字母。
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/20 - 10:22
 */
public class FirstUniqueCharacter {

    /**
     * 利用散列表，存储每个字符出现的次数
     * 时间复杂度：O(N) （只遍历了两次字符串，并且在散列表中的查找操作是常数级别的）
     * 空间复杂度：O(N)   （使用到了散列表）
     *
     * @param s 源字符
     * @return 下标位置或-1
     */
    public static int firstUniqChar(String s) {

        // 遍历字符串，保存每个字符出现的次数
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 再次遍历字符串，判断散列表中出现次数为一次的，并且在字符串中最先出现的字符位置下标
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1));

        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2));
    }
}
