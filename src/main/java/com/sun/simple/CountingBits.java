package com.sun.simple;

/**
 * 【338. 比特位计数】
 * 🔗 https://leetcode-cn.com/problems/counting-bits/
 *
 * @author sunyl
 * @date 2022/2/4 8:17 PM
 * @see com.sun.simple
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            final String binaryValue = Integer.toBinaryString(i);
            res[i] = countOne(binaryValue);
        }
        return res;
    }

    private int countOne(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }

}
