package com.sun.algorithm.everyday;

/**
 * 1071. 字符串的最大公因子
 *
 * @author syl
 * @date 2020/03/12 - 09:20
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        String str1 = "LEET", str2 = "CODE";
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2));
    }
}
