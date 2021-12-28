package com.sun.offerII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【剑指Offer II 004.只出现一次的数字】
 * 🥸 https://leetcode-cn.com/problems/WGki4K/
 *
 * @author sunyl
 * @date 2021/12/27 10:48 上午
 * @see com.sun.offerII
 */
public class Solution004 {

    /**
     * 排序 ➕ 一次遍历
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, single = nums[n - 1];
        for (int i = 0; i < n - 3; i += 3) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return single;
    }

    public int singleNumberWithHash(int[] nums) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int num : nums) {
            tmp.put(num, tmp.getOrDefault(num, 0) + 1);
        }
        int single = 0;
        for (Map.Entry<Integer, Integer> map : tmp.entrySet()) {
            if (map.getValue().equals(1)) {
                single = map.getKey();
                break;
            }
        }
        return single;
    }

    public static void main(String[] args) {
        Solution004 solution = new Solution004();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 100}));

        System.out.println(solution.singleNumberWithHash(new int[]{2, 2, 3, 2}));
        System.out.println(solution.singleNumberWithHash(new int[]{0, 1, 0, 1, 0, 1, 100}));
    }

}
