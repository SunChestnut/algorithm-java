package com.sun.solution.simple;

/**
 * TODO
 *
 * @author syl
 * @date 2020/02/08 - 10:50
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // i 为当前阶数，n 为目标阶数
        return climb(0, n);
    }

    public int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(5));
        System.out.println(stairs.climbStairs(2));
        System.out.println(stairs.climbStairs(3));
    }

}
