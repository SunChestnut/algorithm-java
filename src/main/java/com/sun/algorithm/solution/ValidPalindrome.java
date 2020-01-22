package com.sun.algorithm.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 【简单 Solution125】
 * 题目：验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/22 - 15:13
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        // 将空串定义为有效回文
        if (s.length() == 0) {
            return true;
        }

        // 将字符串内字符全部转换成小写，便于比较
        String sTemp = s.toLowerCase();

        // 排除掉除「字母」和「数字」以外的字符
        List<Character> list = new ArrayList<>();
        for (Character c : sTemp.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(c);
            }
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }

        // 判断是否是回文
        int k = list.size() - 1;
        for (Character character : list) {
            if (character.equals(list.get(k))) {
                k--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        String sT = "race a car";
        System.out.println(isPalindrome(sT));
    }
}
