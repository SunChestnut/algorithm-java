package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 1200. 最小绝对差
 *
 * @author syl
 * @date 2020/04/15 - 09:29
 */
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return null;
        }

        Arrays.sort(arr);
        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minSub = Math.min(minSub, Math.abs(arr[i] - arr[i - 1]));
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int j = 1; j < n; j++) {
            if (Math.abs(arr[j] - arr[j - 1]) == minSub) {
                res.add(new ArrayList<>(Arrays.asList(arr[j - 1], arr[j])));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        List<List<Integer>> res = minimumAbsoluteDifference.minimumAbsDifference(arr);
        System.out.println(res.toString());
    }
}
