package com.sun.offer.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunyl
 * @date 2021/10/27 11:49 上午
 * @see com.sun.offer.simple
 */
@Slf4j
public class Offer10I {

    /**
     * 递归，性能最差
     *
     * @param n
     * @return
     */
    public static int fibWithRecur(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        return (fibWithRecur(n - 1) + fibWithRecur(n - 2)) % 1000000007;
    }

    public static int fibWithLoop(int n) {
        int[] result = {0, 1};
        if (n <= 1) {
            return result[n];
        }
        int a = 0, b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int fibBetter(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static String bar() {
        try {
            System.out.println("abc");
        } finally {
            System.out.println("def");
            return "555";
        }
    }

    public static void main(String[] args) {
//        System.out.println(fibWithRecur(2));
//        System.out.println(fibWithRecur(5));
//        System.out.println(fibWithRecur(45));
//
//        System.out.println(fibWithLoop(1));
//        System.out.println(fibWithLoop(2));
//        System.out.println(fibWithLoop(5));
//        System.out.println(fibWithLoop(45));
//
//        System.out.println(fibBetter(2));
        System.out.println(fibBetter(5));
//        System.out.println(fibBetter(45));
    }
}
