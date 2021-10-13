package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/13 4:32 下午
 * @see com.sun.offer.simple
 */
public class Office05 {

    /**
     * 【Syl】将字符串转成数组，再遍历数组，遇到数组中值与目标值匹配的，将其替换成目标值，并存入字符串中
     *
     * @param s
     * @return
     */
    public static String replaceSpaceA(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        final char[] array = s.toCharArray();
        StringBuilder replaceRes = new StringBuilder();
        for (char temp : array) {
            replaceRes.append(" ".equals(String.valueOf(temp)) ? "%20" : temp);
        }
        return replaceRes.toString();
    }

    /**
     * 【官方题解一】
     *
     * @param s
     * @return
     */
    public static String replaceSpaceB(String s) {
        int n = s.length();
        char[] array = new char[n * 3];
        int index = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (' ' == c) {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        return new String(array, 0, index);
    }


    public static void main(String[] args) {
        System.out.println(replaceSpaceA("We are happy."));
        System.out.println(replaceSpaceB("We are happy."));
    }
}
