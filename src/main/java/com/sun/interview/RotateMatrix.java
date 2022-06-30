package com.sun.interview;

import java.util.Arrays;

/**
 * 【面试题 01.07. 旋转矩阵】
 * <p>
 * 🔗 <a href="https://leetcode.cn/problems/rotate-matrix-lcci/">...</a>
 *
 * @author sunyl
 * @date 2022/6/2 11:05
 * @see com.sun.interview
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            tmp[i] = matrix[i];
        }

        System.out.println(Arrays.deepToString(tmp));
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix.rotate(matrix);

        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(matrix[j][i]);
            }
        }

    }

}
