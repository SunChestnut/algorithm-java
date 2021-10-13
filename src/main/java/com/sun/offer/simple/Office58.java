package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/13 5:17 下午
 * @see com.sun.offer.simple
 */
public class Office58 {

    public static String reverseLeftWords(String s, int n) {
        if (null == s || s.length() == 0) {
            return "";
        }

        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

}
