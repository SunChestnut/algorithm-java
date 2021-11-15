package com.sun.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2021/11/10 10:33 上午
 * @see com.sun.datastructure
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 改进点！为降低空间复杂度，将较短的数组存入 Hash 表中
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> tmpMap = new HashMap<>(nums1.length);
        for (Integer v1 : nums1) {
            tmpMap.put(v1, tmpMap.getOrDefault(v1, 0) + 1);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (Integer v2 : nums2) {
            if (tmpMap.containsKey(v2) && tmpMap.get(v2) != 0) {
                result[index++] = v2;
                tmpMap.put(v2, tmpMap.get(v2) - 1);
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{4}, new int[]{4})));
    }

}
