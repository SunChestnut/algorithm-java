package com.sun.offer.middle;

/**
 * @author sunyl
 * @date 2022/1/20 10:56 AM
 * @see com.sun.offer.middle
 */
public class Offer46 {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        // a,b 分别表示 dp[i],dp[i-1],两个变量交替前进即可省去 dp 列表使用的 O(N) 的额外空间
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            System.out.println(tmp);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


    public static void main(String[] args) {
        Offer46 solution = new Offer46();
        System.out.println(solution.translateNum(12258));
    }
}
