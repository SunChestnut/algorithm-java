package com.sun.datastructure;

/**
 * @author sunyl
 * @date 2021/11/11 12:21 下午
 * @see com.sun.datastructure
 */
public class BetterTimeToBuyAndSellStock {

    /**
     * 暴力破解：超时了
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int sub = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, sub);
            }
        }
        return maxProfit;
    }

    public static int maxProfitBetter(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

        System.out.println(maxProfitBetter(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitBetter(new int[]{7, 6, 4, 3, 1}));
    }

}
