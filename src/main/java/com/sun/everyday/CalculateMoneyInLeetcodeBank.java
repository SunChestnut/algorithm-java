package com.sun.everyday;

/**
 * 【1716. 计算力扣银行的钱】
 * 🔗 https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 *
 * @author sunyl
 * @date 2022/1/16 5:41 PM
 * @see com.sun.everyday
 */
public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int res = 0, day = 1, week = 1;
        for (int i = 0; i < n; i++) {
            res += day + week - 1;
            day++;
            if (day == 8) {
                day = 1;
                week++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank solution = new CalculateMoneyInLeetcodeBank();
        System.out.println(solution.totalMoney(4) == 10);
        System.out.println(solution.totalMoney(10) == 37);
    }
}
