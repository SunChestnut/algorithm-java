package com.sun.algorithm.everyday;

/**
 * 69. x 的平方根
 *
 * @author syl
 * @date 2020/04/02 - 10:01
 */
public class SqrtX {

    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        double x0 = x;
        double x1 = (x0 + x / x0) / 2;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2;
        }
        return (int) x1;
    }

    public static void main(String[] args) {
        SqrtX solution = new SqrtX();
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(4));
    }

}
