package com.sun.solution.simple;

/**
 * 【简单 Solution58】
 * 题目：最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 * ----------------------------------------------------------
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/06 - 20:03
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        // 如果是空串，直接返回0
        if (s.length() == 0) {
            return 0;
        }

        String[] tempStr = s.split(" ");
        if (tempStr.length > 0) {
            return tempStr[tempStr.length - 1].length();
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));

        System.out.println(lengthOfLastWord(" "));

        System.out.println(lengthOfLastWord("a "));
    }

}
