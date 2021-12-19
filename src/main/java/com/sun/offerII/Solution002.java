package com.sun.offerII;

/**
 * @author sunyl
 * @date 2021/12/5 10:40 上午
 * @see com.sun.offerII
 */
public class Solution002 {

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;

            // 每位的值 = (ai+bi+carry)%2
            // 可以通过将 int 值 + '0' 转换成 char 类型。好像将整形转成字符串类型只要加个空串就可以了
            ans.append((char) (carry % 2 + '0'));
            // carry + ai + bi 的值可能是 2、1、0，如果值为 2，那么进位值则为 1；如果值为 1 或 0，那么进位制均为 0
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        return String.valueOf(ans.reverse());
    }

    public static String addBinarySyl(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int n = Math.max(a.length(), b.length()), carry = 0;
        StringBuilder res = new StringBuilder();
        //
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? charsA[a.length() - i - 1] - '0' : 0;
            carry += i < b.length() ? charsB[b.length() - i - 1] - '0' : 0;
            res.append((char) ((carry % 2) + '0'));

            carry /= 2;
        }
        if (carry > 0) {
            res.append('1');
        }
        return String.valueOf(res.reverse());
    }


    public static void main(String[] args) {
        System.out.println(addBinary("11", "10"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "111"));

        System.out.println("------");

        System.out.println(addBinarySyl("11", "10"));
        System.out.println(addBinarySyl("1010", "1011"));
        System.out.println(addBinarySyl("11", "111"));
    }

}
