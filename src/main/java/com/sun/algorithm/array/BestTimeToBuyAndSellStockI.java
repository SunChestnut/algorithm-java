package com.sun.algorithm.array;

/**
 * 题目：买卖股票的最佳时机I
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/7/25 11:19
 **/
class BestTimeToBuyAndSellStockI {

    /**
     * 暴力法
     * 嵌套循环找出 max(prices[j] - prices[i])
     *
     * @param prices 源数组
     * @return int 最大利润
     */
    static int maxProfitI(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历
     * 找出数组中的最大值和最小值，最大值和最小值的差值即最大利润。
     * 注：最大值在数组中的位置应在最小值的位置之后
     *
     * @param prices 源数组
     * @return int 最大利润
     */
    static int maxProfitII(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 同“一次遍历”的解法。
     * 取消使用数据下标的方式循环，直接使用foreach循环。
     * 两种循环的执行用时相同，但使用数组下标循环的方式消耗的内存要少。
     *
     * @param prices 源数组
     * @return int 最大利润
     */
    static int maxProfitIII(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
