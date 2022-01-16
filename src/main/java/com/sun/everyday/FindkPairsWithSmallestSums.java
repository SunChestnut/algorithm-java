package com.sun.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author sunyl
 * @date 2022/1/14 8:44 AM
 * @see com.sun.everyday
 */
public class FindkPairsWithSmallestSums {

    /**
     * 暴力破解，算出两个数组中所有数字配对后的组合
     * 超时了……
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairsForce(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<List<Integer>>> tempMap = new TreeMap<>();
        for (int v1 : nums1) {
            for (int v2 : nums2) {
                int sum = v1 + v2;
                if (tempMap.containsKey(sum)) {
                    List<List<Integer>> curValue = tempMap.get(sum);
                    curValue.add(Arrays.asList(v1, v2));
                } else {
                    List<List<Integer>> newValue = new ArrayList<>();
                    newValue.add(Arrays.asList(v1, v2));
                    tempMap.put(sum, newValue);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> map : tempMap.entrySet()) {
            List<List<Integer>> value = map.getValue();
            res.addAll(value);
        }
        return res.size() > k ? res.subList(0, k) : res;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length, n = nums2.length;


        return null;
    }

    public static void main(String[] args) {
        FindkPairsWithSmallestSums solution = new FindkPairsWithSmallestSums();
        System.out.println(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(solution.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
