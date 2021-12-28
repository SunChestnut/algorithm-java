package com.sun.alogorithm.elementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunyl
 * @date 2021/12/28 10:08 上午
 * @see com.sun.alogorithm.elementary
 */
public class IntersectionOfTwoArrayII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> countNum1 = new HashMap<>(nums1.length);
        List<Integer> res = new ArrayList<>();
        for (int v : nums1) {
            countNum1.put(v, countNum1.getOrDefault(v, 0) + 1);
        }
        for (int v : nums2) {
            if (countNum1.containsKey(v) && countNum1.get(v) != 0) {
                res.add(v);
                countNum1.put(v, countNum1.get(v) - 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrayII solution = new IntersectionOfTwoArrayII();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
