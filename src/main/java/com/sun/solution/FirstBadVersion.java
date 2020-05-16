package com.sun.solution;

/**
 * leetcode 278. 第一个错误的版本
 *
 * @author syl
 * @date 2020/05/16 - 09:25
 */
public class FirstBadVersion {

    boolean isBadVersion(int version) {
        return version != 1 && version != 2 && version != 3;
    }

    public int firstBadVersion(int n) {

        int mid, left = 1, right = n;

        // 当 left == right 时，表示找到了第一个错误版本的位置
        while (left < right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        System.out.println(solution.firstBadVersion(5));
    }
}
