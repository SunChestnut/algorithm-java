package com.sun.binarysearch;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @author sunyl
 * @date 2021/12/19 5:35 下午
 * @see com.sun.binarysearch
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num, mid;
        long square;
        while (left <= right) {
            mid = left + (right - left) / 2;

            square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare solution = new ValidPerfectSquare();
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(4));
        System.out.println(solution.isPerfectSquare(10));
        System.out.println(solution.isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }
}
