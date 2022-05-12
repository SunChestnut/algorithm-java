package com.sun.lc;

/**
 * 【240. 搜索二维矩阵 II】
 * 🔗 https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author sunyl
 * @date 2022/2/9 8:41 AM
 * @see com.sun.lc
 */
public class SearchA2dMatrixIi {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] v : matrix) {
            if (findTarget(v, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean findTarget(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        SearchA2dMatrixIi solution = new SearchA2dMatrixIi();
        System.out.println(solution.searchMatrix(matrix, 20));
    }
}


