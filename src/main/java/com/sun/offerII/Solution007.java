package com.sun.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/1fGaJU/"> 🔗【剑指 Offer II 007. 数组中和为 0 的三个数】</a>
 *
 * @author sunyl
 * @date 2022/6/27 14:23
 * @see com.sun.offerII
 */
public class Solution007 {

    /**
     * 排序 + 双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> judgeRepeat = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum + nums[i] == 0) {
                    // 判重
                    List<Integer> cur = List.of(nums[i], nums[l], nums[r]);
                    String sortedNums = cur.toString();
                    if (!judgeRepeat.contains(sortedNums)) {
                        judgeRepeat.add(sortedNums);
                        res.add(cur);
                    }
                    l++;
                    r--;
                } else if (sum + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    /**
     * 【优化去重部分】直接使用 Set 集合存储结果三元组，省去了使用字符串去重的过程，在结果时再转成 List 即可
     * 因将 Set 转成 List 也需要 O(n) 时间级别的复杂度，所以整体的时间复杂度相较于上面的方法提升并不高
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumOptimize01(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum + nums[i] == 0) {
                    // 判重
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 【优化去重部分】在双指针循环过程中，左右指针移动后，分别判断移动后的左右指针和移动前的值是否相同，如果相同，表明有重复的元素，继续移动左右指针即可
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumOptimize02(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            // 优化点
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 下行代码等同于：while (left < right && nums[left] == nums[++left]);
                    while (l < r) {
                        l++;
                        if (nums[l - 1] != nums[l]) {
                            break;
                        }
                    }
                    // 下行代码等同于：while (left < right && nums[right] == nums[--right]);
                    while (l < r) {
                        r--;
                        if (nums[r + 1] != nums[r]) {
                            break;
                        }
                    }
                } else if (sum + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution007 solution = new Solution007();
        System.out.println(solution.threeSumOptimize02(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSumOptimize02(new int[]{}));
        System.out.println(solution.threeSumOptimize02(new int[]{0}));
        System.out.println(solution.threeSumOptimize02(new int[]{1, 1, -2}));
    }
}
