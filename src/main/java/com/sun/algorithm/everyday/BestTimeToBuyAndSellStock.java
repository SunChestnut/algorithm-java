package com.sun.algorithm.everyday;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/09 - 09:37
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, (prices[j] - prices[i]));
                }
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
