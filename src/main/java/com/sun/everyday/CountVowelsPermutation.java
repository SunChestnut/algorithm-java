package com.sun.everyday;

/**
 * 【1220. 统计元音字母序列的数目】
 * 🔗 https://leetcode-cn.com/problems/count-vowels-permutation/
 *
 * @author sunyl
 * @date 2022/1/17 9:52 AM
 * @see com.sun.everyday
 */
public class CountVowelsPermutation {

    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            ndp[1] = (dp[0] + dp[2]) % mod;
            ndp[2] = (dp[1] + dp[3]) % mod;
            ndp[3] = dp[2];
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }

}
