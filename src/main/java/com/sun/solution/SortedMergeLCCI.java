package com.sun.solution;

import java.util.Arrays;

/**
 * leetcode每日一题：面试题 10.01. 合并排序的数组
 *
 * @author syl
 * @date 2020/03/03 - 09:12
 */
public class SortedMergeLCCI {

    public void merge(int[] A, int m, int[] B, int n) {

        assert m >= 0 && n >= 0;

        System.arraycopy(B, 0, A, m, n);

        Arrays.sort(A);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        new SortedMergeLCCI().merge(A, 3, B, 3);

        System.out.println(Arrays.toString(A));
    }


}
