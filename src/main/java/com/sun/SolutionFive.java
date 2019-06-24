package com.sun;


import com.sun.model.ExampleModel;
import com.sun.util.ToolUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * ----------------------------------------------------------
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * ----------------------------------------------------------
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/20 17:08
 **/
public class SolutionFive {

    private static String longestPalindrome(String s) {

        // 获取字符串中的所有子串
        List<String> list = new ArrayList<String>();
        if (s != null && !"".equals(s)) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    list.add(s.substring(i, j));
                }
            }
        }

        // 找出子串中的回文串
        if (list.size() > 0) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String str = String.valueOf(iterator.next());
                StringBuilder reverseStr = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; i--) {
                    char a = str.charAt(i);
                    reverseStr.append(a);
                }
                if (!str.contentEquals(reverseStr)) {
                    iterator.remove();
                }
            }
        }

        // 找出最长的回文字串
        int length = 0;
        String result = "";
        if (list.size() > 0) {
            for (String s1 : list) {
                if (length < s1.length()) {
                    length = s1.length();
                    result = s1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Date date = new Date();
        String str = ExampleModel.exampleOne;
        System.out.println(longestPalindrome(str));
        System.out.println("代码执行共消耗：" + ToolUtil.runTime(date) + "s");
    }
}
