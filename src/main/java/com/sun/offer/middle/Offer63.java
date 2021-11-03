package com.sun.offer.middle;

/**
 * 【股票的最大利润】
 *
 * @author sunyl
 * @date 2021/10/31 12:11 下午
 * @see com.sun.offer.middle
 */
public class Offer63 {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int diff = 0;
        // for VS foreach
        // Math.min 内部使用三元运算法则进行比较，和直接使用 if 条件比较相比，有什么区别？
        // 或者说，三元运算符的原理是什么？
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (diff < (prices[i] - min)) {
                diff = prices[i] - min;
            }
//            min = Math.min(min, prices[i]);
//            diff = Math.max(diff, (prices[i] - min));
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{}));
    }

}
