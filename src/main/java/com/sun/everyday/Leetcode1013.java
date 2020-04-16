package com.sun.everyday;

import java.util.Arrays;

/**
 * leetcode1013. 将数组分成和相等的三个部分
 *
 * @author syl
 * @date 2020/03/11 - 20:48
 */
public class Leetcode1013 {

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = Arrays.stream(A).reduce(0, Integer::sum);
        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }

            ++i;
        }

        if (cur != target) {
            return false;
        }

        int j = i + 1;
        while (j + 1 < n) {
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        System.out.println(new Leetcode1013().canThreePartsEqualSum(A));
    }
}
