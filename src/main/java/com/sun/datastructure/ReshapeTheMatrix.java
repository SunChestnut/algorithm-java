package com.sun.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/11/15 11:07 上午
 * @see com.sun.datastructure
 */
public class ReshapeTheMatrix {

    public static int[][] matrixReshapeSyl(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        // 如果重塑之后的二维数组的元素总数不等于原二维数组的元素总数，则无法重塑
        if (m * n != r * c) {
            return mat;
        }
        // 将原二维数组存入集合中，便于后续负值给重塑后的二维数组
        List<Integer> tmp = new ArrayList<>();
        for (int[] v : mat) {
            for (int j = 0; j < n; j++) {
                tmp.add(v[j]);
            }
        }
        int[][] reshapeResult = new int[r][c];
        int index = 0;
        for (int a = 0; a < r; a++) {
            for (int b = 0; b < c; b++) {
                reshapeResult[a][b] = tmp.get(index++);
            }
        }
        return reshapeResult;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        // 对于 x∈[0,mn)，第 x 个元素在nums 中对应的下标为(x/n)(x%n)，
        // 而在新的重塑矩阵中对应的下标为(x/c)(x%c)。我们直接进行赋值即可
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            ans[x / c][x % c] = mat[x / n][x % n];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshapeSyl(new int[][]{
                {1, 2},
                {3, 4}
        }, 1, 4)));

        System.out.println(Arrays.deepToString(matrixReshapeSyl(new int[][]{
                {1, 2},
                {3, 4}
        }, 2, 4)));

        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{
                {1, 2},
                {3, 4}
        }, 1, 4)));

        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{
                {1, 2},
                {3, 4}
        }, 2, 4)));
    }

}
