package com.sun.solution;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author syl
 * @date 2020/05/24 - 08:37
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 先通过二分查找确定 target 值是否存在，
     * 如果存在的话，在数组中的下标是多少，并以这个下标为中心点，分别向两边查找是否还有 target 值
     *
     * @param nums   待查找数组
     * @param target 目标值
     * @return 目标值在数组中的开始位置和结束位置
     */
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = n - 1, sPosition = -1, ePosition = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {

                // 以 mid 为中心点，分别设置指针 i 和指针 j 遍历从中心点两侧开始遍历
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    sPosition = i;
                    --i;
                }
                int j = mid;
                while (j <= n - 1 && nums[j] == target) {
                    ePosition = j;
                    ++j;
                }
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{sPosition, ePosition};
    }

    /**
     * 官方解法
     *
     * @param nums   待查找数组
     * @param target 目标值
     * @return 目标值在数组中的开始位置和结束位置
     */
    public int[] searchRangeFromOfficial(int[] nums, int target) {

        int[] targetRange = new int[]{-1, -1};

        int leftIndex = extremeInsertionIndex(nums, target, true);

        // nums 中不存在 target 值的情况
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }

        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
