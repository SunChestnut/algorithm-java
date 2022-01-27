package com.sun.offer.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 【剑指 Offer 10- II. 青蛙跳台阶问题】
 * 🔗 https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author sunyl
 * @date 2021/10/30 5:52 下午
 * @see com.sun.offer.simple
 */
public class Offer10II {

    private final static Map<Integer, Integer> MEMO;

    static {
        MEMO = new HashMap<>();
        MEMO.put(0, 1);
        MEMO.put(1, 1);
        MEMO.put(2, 2);
    }


    /**
     * 记忆搜索版的递归
     *
     * @param n
     * @return
     */
    public static int numWaysWithMemoryRecur(int n) {
        if (MEMO.containsKey(n)) {
            return MEMO.get(n);
        } else {
            int value = (numWaysWithMemoryRecur(n - 1) + numWaysWithMemoryRecur(n - 2)) % 1000000007;
            MEMO.put(n, value);
        }
        return MEMO.get(n);
    }

    public static int numWaysWithDp(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        if (n > 0) {
            arr[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n];
    }

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
        System.out.println(numWaysWithMemoryRecur(7));
        System.out.println(numWaysWithDp(44));
    }

}
