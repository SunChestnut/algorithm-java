package com.sun.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author syl
 * @date 2019/10/08 - 14:40
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> integers = new ArrayList<>();

        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    integers.add(a);
                    break;
                }
            }
        }

        int[] resultValue = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            resultValue[i] = integers.get(i);
        }

        return resultValue;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

}
