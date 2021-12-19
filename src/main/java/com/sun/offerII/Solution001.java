package com.sun.offerII;

/**
 * @author sunyl
 * @date 2021/11/20 3:23 下午
 * @see com.sun.offerII
 */
public class Solution001 {

    public static int divide(int a, int b) {
        if (Integer.MIN_VALUE == a && -1 == b) {
            return Integer.MAX_VALUE;
        }
        // 逻辑运算符异或：两个条件中的一个为 true 时，结果才为 true
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(15, 2));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, -1));
        System.out.println(divide(1, 1));
    }

}















