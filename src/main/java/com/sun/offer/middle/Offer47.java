package com.sun.offer.middle;

/**
 * @author sunyl
 * @date 2021/11/1 7:48 下午
 * @see com.sun.offer.middle
 */
public class Offer47 {

    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 当 i == 0 && j != 0 时，为矩阵第一行元素，只能从左边到达
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    // 当 i != 0 && j == 0 时，为矩阵第一列元素，只能从下面到达
                    grid[i][j] += grid[i - 1][j];
                } else {
                    // 当 i != 0 && j != 0 时，可以从左边或上边到达
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(maxValue(grid1));
        System.out.println(maxValueSyl(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(maxValueSylBetter(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));

        int[][] grid2 = {{1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};
        System.out.println(maxValue(grid2));
        System.out.println(maxValueSyl(new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}}));
        System.out.println(maxValueSylBetter(new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}}));
    }


    public static int maxValueSyl(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[rows - 1][columns - 1];
    }

    public static int maxValueSylBetter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 优化上述方法中，每次循环都需要先判断 i 和 j 是否全部等于 1
        // 先初始化第一行的值和第一列的值，后续的潜逃循环直接从第一行第一列开始
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

}
