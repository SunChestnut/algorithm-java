package com.sun.everyday;

/**
 * 【完美数】
 * 🔗 https://leetcode-cn.com/problems/perfect-number/
 *
 * @author sunyl
 * @date 2021/12/31 11:50 下午
 * @see com.sun.everyday
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = num / 2; i > 0; i--) {
            if (num % i == 0) {
                sum += i;
            }
        }
//        for (int d = 2; d * d <= num; d++) {
//            if (num % d == 0) {
//                sum += d;
//                if (d * d < num) {
//                    sum += num / d;
//                }
//            }
//        }
        return num == sum;
    }

    public static void main(String[] args) {
        PerfectNumber solution = new PerfectNumber();
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber(2));
        System.out.println(solution.checkPerfectNumber(6));
        System.out.println(solution.checkPerfectNumber(496));
    }

}
