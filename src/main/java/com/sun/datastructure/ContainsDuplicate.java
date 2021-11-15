package com.sun.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/11/4 2:26 下午
 * @see com.sun.datastructure
 */
public class ContainsDuplicate {

    /**
     * 使用额外的空间存放数组中的数据
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicateA(int[] nums) {
        Set<Integer> tmpSet = new HashSet<>();
        for (Integer v : nums) {
            // ❗️ 没必要
//            if (tmpSet.contains(v)) {
//                return true;
//            }
//            tmpSet.add(v);
            if (!tmpSet.add(v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateB(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i])) {
                return new int[]{tmpMap.get(target - nums[i]), i};
            }
            tmpMap.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        System.out.println(containsDuplicateA(new int[]{}));
        System.out.println(containsDuplicateA(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicateA(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicateA(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));

        System.out.println(containsDuplicateB(new int[]{}));
        System.out.println(containsDuplicateB(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicateB(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicateB(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

}
