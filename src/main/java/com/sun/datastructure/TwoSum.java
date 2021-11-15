package com.sun.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2021/11/5 7:41 下午
 * @see com.sun.datastructure
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3}, 6)));
    }

}
