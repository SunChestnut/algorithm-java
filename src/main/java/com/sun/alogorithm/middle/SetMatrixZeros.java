package com.sun.alogorithm.middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunyl
 * @date 2021/12/26 10:12 下午
 * @see com.sun.alogorithm.middle
 */
public class SetMatrixZeros {

    /**
     * 使用了一个额外的数组空间标记需要置为0的列，用时间换空间
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 使用该数组标记在 matrix 应该置为 0 的列
        int[] waitZeroColumn = new int[n];
        for (int i = 0; i < m; i++) {
            List<Integer> rowList = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
            if (rowList.contains(0)) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        waitZeroColumn[j] = 1;
                    }
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (waitZeroColumn[j] == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用两个额外的数组，分别标记需要置为 0 的行和列，用空间换时间
     *
     * @param matrix
     */
    public void setZeroesBetter(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == matrix[i][j]) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros solution = new SetMatrixZeros();
        int[][] matrixA = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrixB = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroesBetter(matrixA);
        System.out.println(Arrays.deepToString(matrixA));

        solution.setZeroesBetter(matrixB);
        System.out.println(Arrays.deepToString(matrixB));
    }
}
