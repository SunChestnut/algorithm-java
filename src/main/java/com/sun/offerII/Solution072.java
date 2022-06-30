package com.sun.offerII;

/**
 * <a href="https://leetcode.cn/problems/jJ0w9p/">🔗【剑指 Offer II 072. 求平方根】</a>
 *
 * @author sunyl
 * @date 2022/6/30 09:48
 * @see com.sun.offerII
 */
public class Solution072 {

    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution072 solution = new Solution072();
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(9667788));
        System.out.println(solution.mySqrt(6));
    }

}
