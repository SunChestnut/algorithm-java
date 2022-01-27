package com.sun.interview;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2021/12/31 11:32 上午
 * @see com.sun.interview
 */
public class Solution2 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length, index = 0;
        int[] res = new int[k];
        for (int i = 0; i < m; i++) {
            int countOne = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    countOne += 1;
                }
            }
            if (countOne > res[index] && index < k) {
                res[++index] = countOne;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, 3)));
    }

}
