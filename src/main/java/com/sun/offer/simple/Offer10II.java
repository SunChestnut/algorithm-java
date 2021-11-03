package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/30 5:52 下午
 * @see com.sun.offer.simple
 */
public class Offer10II {

    public static int numWays(int n) {
        int[] arr = {1, 1, 2};
        if (n <= 2) {
            return arr[n];
        }
        int a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numWays(2));
        System.out.println(numWays(7));
        System.out.println(numWays(0));
    }

}
