package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/31 3:43 下午
 * @see com.sun.offer.simple
 */
public class Offer42 {

    /**
     * 【解法一】举例分析数组的规律
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int curSum = Integer.MIN_VALUE, greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 当数组中的值均 < 0 时，数组中的最大值即为最大和
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    /**
     * 【解法二】动态规划法
     * <p>
     * 用函数 f(i) 表示以第 i 个数字结尾的子数组的最大和
     * f(i) = nums(i)       (i == 0 || f(i-1) <= 0)
     * f(i) = nums(i-1) + nums(i)       (i != 0 && f(i - 1) > 0)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));
        System.out.println(maxSubArray1(new int[]{-2, -3, -1, -5, -8}));

        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray2(new int[]{-2, -3, -1, -5, -8}));
    }

}
