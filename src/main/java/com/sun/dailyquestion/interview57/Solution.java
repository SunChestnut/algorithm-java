package com.sun.dailyquestion.interview57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode面试题57 - II. 和为s的连续正数序列
 *
 * @author syl
 * @date 2020/03/06 - 11:02
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {

        List<List<Integer>> res = new ArrayList<>();

        int i = 1;
        while (i < target) {

            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < target; j++) {
                sum += j;
                if (sum > target) {
                    break;
                }
                if (sum == target) {
                    for (int a = i; a <= j; a++) {
                        temp.add(a);
                    }
                }
            }

            if (temp.size() > 0) {
                res.add(temp);
            }

            i++;
        }

        int[][] array = new int[res.size()][];
        for (int a = 0; a < res.size(); a++) {
            List<Integer> list = res.get(a);
            int[] tempArray = list.stream().mapToInt(Integer::intValue).toArray();
            array[a] = tempArray;
        }

        return array;
    }

    public static void main(String[] args) {
        int[][] res = new Solution().findContinuousSequence(15);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
