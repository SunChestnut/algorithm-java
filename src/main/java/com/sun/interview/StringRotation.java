package com.sun.interview;

/**
 * 【面试题 01.09. 字符串轮转】
 * <p>
 * 🔗 <a href="https://leetcode.cn/problems/string-rotation-lcci/">...</a>
 *
 * @author sunyl
 * @date 2022/6/13 10:11
 * @see com.sun.interview
 */
public class StringRotation {

    /**
     * 遍历 s1，每次旋转 s1 以判断是否和 s2 相等
     *
     * @param s1 旋转前字符串
     * @param s2 旋转后字符串
     * @return 是/否
     */
    public static boolean isFlipedString(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 1; i < n1; i++) {
            String tmp = s1.substring(i) + s1.substring(0, i);
            if (tmp.equals(s2)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 首先判断两个字符串长度是否相等，如果不相等，则 s2 肯定不是由 s1 旋转而来的。
     * 然后拼接两个 s2，如果 s2 是由 s1 旋转而来的，则拼接后的 s2 肯定会包含 s1
     *
     * @param s1 旋转前字符串
     * @param s2 旋转后字符串
     * @return 是/否
     */
    public static boolean isFlipedStringBetter(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        return s.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(StringRotation.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(StringRotation.isFlipedString("", ""));
    }

}
