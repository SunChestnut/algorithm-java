package com.sun.everyday;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * 【219. 存在重复元素 II】
 * 🔗 https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * @author sunyl
 * @date 2022/1/19 9:46 AM
 * @see com.sun.everyday
 */
@Slf4j
public class ContainsDuplicateIi {

    /**
     * 暴力破解，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateWithViolence(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateWithHash(int[] nums, int k) {
        Set<Integer> memo = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo.contains(nums[i])) {
                return true;
            }
            memo.add(nums[i]);
            if (memo.size() > k) {
                memo.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicateIi solution = new ContainsDuplicateIi();
//        System.out.println(solution.containsNearbyDuplicateWithHash(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicateWithHash(new int[]{2, 3, 1, 5, 8, 3, 5, 1}, 4));
    }

}
