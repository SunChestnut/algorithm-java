package com.sun.solution;

/**
 * 69. x 的平方根
 *
 * @author syl
 * @date 2020/05/12 - 08:49
 */
public class Sqrtx {

    /**
     * 利用二分法求解
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param x x
     * @return √x
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            // int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Sqrtx solution = new Sqrtx();

        long startTime = System.currentTimeMillis();
        System.out.println(solution.mySqrt(2147395599));
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

}
