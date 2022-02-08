package com.sun.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 【448. 找到所有数组中消失的数字】
 * 🔗 https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author sunyl
 * @date 2022/2/3 7:48 PM
 * @see com.sun.simple
 */
public class FindAllNumbersDisappearedInAnArray {

    /**
     * 「 鸽笼原理 」
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i : nums) {
            arr[i - 1] = -1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray solution = new FindAllNumbersDisappearedInAnArray();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
