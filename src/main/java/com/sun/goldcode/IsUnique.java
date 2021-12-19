package com.sun.goldcode;

/**
 * 【面试题 01.01. 判定字符是否唯一】
 *
 * @author sunyl
 * @date 2021/12/1 6:53 下午
 * @see com.sun.goldcode
 */
public class IsUnique {

    public static boolean isUnique(String astr) {
        int[] array = new int[26];
        if (0 == astr.length()) {
            return true;
        }
        for (int i = 0; i < astr.length(); i++) {
            int res = astr.charAt(i) - 'a';
            if (array[res] == 1) {
                return false;
            } else {
                array[res] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
        System.out.println(isUnique("abc"));

        System.out.println('a' - '0');
    }

}
