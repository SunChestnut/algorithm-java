package com.sun.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 56. 合并区间
 *
 * @author syl
 * @date 2020/04/20 - 09:36
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] v : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 数组中最后区间的终止位置，则不合并，直接将当前区间加入结果数组
            if (idx == -1 || v[0] > res[idx][1]) {
                res[++idx] = v;
            } else {
                res[idx][1] = Math.max(res[idx][1], v[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        MergeIntervals solution = new MergeIntervals();
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

}
