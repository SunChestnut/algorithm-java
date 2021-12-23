package com.sun.alogorithm.elementary;

/**
 * @author sunyl
 * @date 2021/12/22 4:44 下午
 * @see com.sun.alogorithm.elementary
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // ⚠️ 题目中没有说明不能在同一天买入和卖出，因此购买股票没有限制
            if (prices[i] > prices[i - 1]) {
                bestProfit += (prices[i] - prices[i - 1]);
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

}
