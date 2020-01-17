package com.sun.algorithm.array;

/**
 * 题目：旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * ----------------------------------------------------------
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * ----------------------------------------------------------
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * ----------------------------------------------------------
 * 说明:
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/01/17 - 10:39
 */
public class RotateImage {

    private RotateImage() {
    }

    public static void rotate(int[][] matrix) {
        final int n = matrix.length;

        // 沿着副对角线反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }

        // 沿着水瓶中线反转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }

    }

    private static void swap(final int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrixOne = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixTwo = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrixTwo);

        for (int[] ints : matrixTwo) {
            for (int j = 0; j < matrixTwo.length; j++) {
                System.out.println(ints[j]);
            }
        }
    }
}
