package com.sun.solution;

/**
 * @author sunyl
 * @date 2021/12/11 11:03 上午
 * @see com.sun.solution
 */
public class MyPow {

    public double myPow(double x, int n) {
        return n > 0 ? quickMulti(x, n) : 1.0 / quickMulti(x, n);
    }

    public double quickMulti(double x, long n) {
        if (0 == n) {
            return 1.0;
        }
        double y = quickMulti(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    public static void main(String[] args) {
        MyPow solution = new MyPow();
        System.out.println(solution.myPow(2.00000, 10));
        System.out.println(solution.myPow(2.10000, 3));
        System.out.println(solution.myPow(2.00000, -2));
        System.out.println(solution.myPow(3.00000, -2));
        System.out.println(Math.pow(3.00000, -2));
    }

}
