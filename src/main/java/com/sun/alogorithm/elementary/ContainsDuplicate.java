package com.sun.alogorithm.elementary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/12/25 11:25 上午
 * @see com.sun.alogorithm.elementary
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateWithSet(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for (Integer v : nums) {
            if (!tmp.add(v)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));

        System.out.println(solution.containsDuplicateWithSet(new int[]{1, 2, 3, 1}));
        System.out.println(solution.containsDuplicateWithSet(new int[]{1, 2, 3, 4}));
        System.out.println(solution.containsDuplicateWithSet(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
