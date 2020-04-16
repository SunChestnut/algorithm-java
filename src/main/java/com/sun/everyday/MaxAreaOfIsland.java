package com.sun.everyday;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/15 - 09:35
 */
public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }

        return ans;
    }

    int dfs(int[][] grid, int curi, int curj) {
        if (curi < 0 || curj < 0 || curi == grid.length || curj == grid[0].length || grid[curi][curj] != 1) {
            return 0;
        }

        grid[curi][curj] = 0;

        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int nexti = curi + di[index], nextj = curj + dj[index];
            ans += dfs(grid, nexti, nextj);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland island = new MaxAreaOfIsland();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(island.maxAreaOfIsland(grid));
    }
}
