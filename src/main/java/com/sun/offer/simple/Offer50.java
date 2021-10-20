package com.sun.offer.simple;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2021/10/19 5:03 下午
 * @see com.sun.offer.simple
 */
public class Offer50 {

    public static char firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> countChar = new LinkedHashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            countChar.put(c, countChar.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> temp : countChar.entrySet()) {
            if (temp.getValue() == 1) {
                return temp.getKey();
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
//        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar("leetcode"));
    }
}
