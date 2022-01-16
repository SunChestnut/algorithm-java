package com.sun.offer.simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 【剑指 Offer 10- I. 斐波那契数列】
 * 🔗 https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author sunyl
 * @date 2021/10/27 11:49 上午
 * @see com.sun.offer.simple
 */
@Slf4j
public class Offer10I {

    private static final Map<Integer, Integer> MEMO;

    static {
        MEMO = new HashMap<>();
        MEMO.put(0, 0);
        MEMO.put(1, 1);
    }

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
        System.out.println("Cur Value : " + n);
        return (fibWithRecur(n - 1) + fibWithRecur(n - 2)) % 1000000007;
    }

    /**
     * 使用【记忆搜索法】优化递归算法
     *
     * @param n
     * @return
     */
    public static int fibWithRecurBetter(int n) {
        if (MEMO.containsKey(n)) {
            return MEMO.get(n);
        } else {
            MEMO.put(n, (fibWithRecurBetter(n - 1) + fibWithRecurBetter(n - 2)) % 1000000007);
        }
        return MEMO.get(n);
    }

    /**
     * 遍历一次，设置两个指针，遍历求和
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
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

    /**
     * 循环一次求解，优化循环的部分，从 0 开始，去掉上述方法中使用的额外空间
     *
     * @param n
     * @return
     */
    public static int fibWithPointer(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 循环一次求解，直接使用数组作为额外空间，存储每个 n 对应的斐波那契数列的值
     *
     * @param n
     * @return
     */
    public static int fibWithArray(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1000000007;
        }
        return array[n];
    }

    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.now();
        System.out.println("Finial Res : " + fibWithRecurBetter(999));
        LocalDateTime finish = LocalDateTime.now();
        Duration duration = Duration.between(start, finish);
        System.out.println("Spend Time : " + duration.getNano());

//        System.out.println(fibWithLoop(1));
//        System.out.println(fibWithLoop(2));
//        System.out.println(fibWithLoop(5));
//        System.out.println(fibWithLoop(45));
//
//        System.out.println(fibBetter(2));
//        System.out.println(fibBetter(5));
//        System.out.println(fibBetter(45));
    }
}
