package com.sun.algorithm.dailyquestion.interview40;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 *
 * @author syl
 * @date 2020/03/20 - 09:10
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);

        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);

        System.out.println(Arrays.toString(result));
    }
}
