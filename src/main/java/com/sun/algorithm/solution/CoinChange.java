package com.sun.algorithm.solution;

import java.util.Arrays;

/**
 * leetcode322: 零钱兑换 ❓
 *
 * @author syl
 * @date 2020/03/08 - 19:29
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
