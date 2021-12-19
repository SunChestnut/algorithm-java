package com.sun.binarysearch.modelii;

/**
 * @author sunyl
 * @date 2021/12/9 10:10 上午
 * @see com.sun.algorithm
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
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

    private boolean isBadVersion(int version) {
        return version == 3 || version == 4 || version == 5;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        System.out.println(solution.firstBadVersion(5));
    }

}
