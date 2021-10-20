package com.sun.offer.middle;

/**
 * @author sunyl
 * @date 2021/10/16 7:34 下午
 * @see com.sun.offer.middle
 */
public class Offer04 {

    /**
     * 暴力解，但忽略了排序数组的特性
     *
     * @param matrix 初始二维数组
     * @param target 目标值
     * @return 是/否
     */
    public static boolean findNumberIn2DArrayA(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int columns = matrix[0].length;
        for (int[] arr : matrix) {
            for (int j = 0; j < columns; j++) {
                if (arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArrayB(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, colums = matrix[0].length;
        int r = 0, c = colums - 1;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
                {18, 21, 23, 26, 30}};
//        System.out.println(findNumberIn2DArrayA(matrix1, 14));
//        System.out.println(findNumberIn2DArrayA(matrix1, 20));
//        System.out.println(findNumberIn2DArrayB(matrix1, 14));
//        System.out.println(findNumberIn2DArrayB(matrix1, 20));

        int[][] matrix2 = {{-5}};
        System.out.println(findNumberIn2DArrayB(matrix2, -5));
    }
}
