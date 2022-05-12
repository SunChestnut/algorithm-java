package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 *
 * 回溯法
 *
 * @author syl
 * @date 2020/04/21 - 08:53
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        // 初始化输出集合
        List<List<Integer>> output = new ArrayList<>();

        ArrayList<Integer> numsList = new ArrayList<>();
        Arrays.stream(nums).forEach(numsList::add);

        int n = nums.length;
        backtrack(n, numsList, output, 0);

        return output;
    }

    private void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {

        // 所有的元素都已经被使用
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }

    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        System.out.println(result.toString());
    }

}
