package com.sun.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode169. 多数元素
 *
 * @author syl
 * @date 2020/03/13 - 08:49
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> elements = new HashMap<>();

        for (int value : nums) {
            elements.put(value, elements.getOrDefault(value, 0) + 1);
        }

        assert elements.size() > 0;

        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums2));
    }
}
