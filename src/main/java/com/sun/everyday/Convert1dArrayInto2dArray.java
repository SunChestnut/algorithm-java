package com.sun.everyday;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/1/1 12:10 上午
 * @see com.sun.everyday
 */
public class Convert1dArrayInto2dArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (n * m != original.length) {
            return new int[0][0];
        }
        int[][] matrix = new int[m][n];
        int begin = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(original, begin, matrix[i], 0, n);
            begin += n;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Convert1dArrayInto2dArray solution = new Convert1dArrayInto2dArray();
        int[][] resA = solution.construct2DArray(new int[]{4, 5, 1}, 3, 1);
        System.out.println(Arrays.deepToString(resA));
        int[][] resB = solution.construct2DArray(new int[]{1, 2, 3}, 1, 3);
        System.out.println(Arrays.deepToString(resB));
    }
}
