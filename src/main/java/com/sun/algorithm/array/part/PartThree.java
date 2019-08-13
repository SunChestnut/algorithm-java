package com.sun.algorithm.array.part;

/**
 * ----------------------------------------------------------
 * <p>
 * ----------------------------------------------------------
 * <p>
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/7/29 9:41
 **/
public class PartThree {

    private static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 利润
        int profit = 0;
        // 当前最小值
        int curMin = prices[0];

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - curMin);
            curMin = Math.min(curMin, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
    }

    /*
     *
     *
     *
     * @param
     * @return
     */

}
