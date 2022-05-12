package com.sun.alogorithm.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author sunyl
 * @date 2022/5/6 15:31
 * @see com.sun.alogorithm.middle
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4) {
            return res;
        }
        Arrays.sort(nums);
        Set<String> judgeRepeat = new HashSet<>();
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int c = b + 1, d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target && judgeRepeat.add(nums[a] + "" + nums[b] + "" + nums[c] + "" + nums[d])) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(res);
    }

}
