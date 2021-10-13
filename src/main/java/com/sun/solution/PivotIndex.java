package com.sun.solution;

/**
 * 724. 寻找数组的中心索引
 *
 * @author syl
 * @date 2020/10/31 - 14:41
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {

        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {-1, -1, -1, -1, 0, 1};

        PivotIndex demo = new PivotIndex();
        int result1 = demo.pivotIndex(nums1);
        int result2 = demo.pivotIndex(nums2);
        int result3 = demo.pivotIndex(nums3);

        System.out.println(result2);
        System.out.println(result1);
        System.out.println(result3);
    }

}
