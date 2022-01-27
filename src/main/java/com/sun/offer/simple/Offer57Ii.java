package com.sun.offer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 【剑指 Offer 57 - II. 和为s的连续正数序列】
 * 🔗 https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author sunyl
 * @date 2022/1/25 11:31 AM
 * @see com.sun.offer.simple
 */
public class Offer57Ii {

    public static int[][] findContinuousSequence(int target) {
        List<List<Integer>> tmpRes = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            int sum = i;
            List<Integer> sumList = new ArrayList<>();
            sumList.add(i);
            for (int j = i + 1; j < target; j++) {
                if (sum == target && !tmpRes.contains(sumList)) {
                    tmpRes.add(sumList);
                } else if (sum < target) {
                    sum += j;
                    sumList.add(j);
                } else {
                    break;
                }
            }
        }
        System.out.println(tmpRes);
        int[][] res = new int[tmpRes.size()][];
        int index = 0;
        for (List<Integer> v : tmpRes) {
            int[] tmp = v.stream().mapToInt(Integer::intValue).toArray();
            res[index++] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }
}
