package com.sun.algorithm.solution;

import java.util.*;

/**
 * 题目： 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * ----------------------------------------------------------
 * 说明：
 * - 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * - 我们可以不考虑输出结果的顺序。
 * ----------------------------------------------------------
 * 进阶:
 * - 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * - 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * - 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2019/10/08 - 14:40
 */
public class IntersectionOfTwoArraysII {

    /**
     * 方法一：哈希映射
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public static int[] intersectI(int[] nums1, int[] nums2) {

        // 如果nums1中的元素个数大于nums2中的元素个数，则交换数组元素
        if (nums1.length > nums2.length) {
            return intersectI(nums2, nums1);
        }

        // 对于nums1中的每个元素，添加的HashMap中，并计算每个元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 初始化k=0，记录当前交集元素的个数
        int k = 0;
        // 遍历数组nums2，检查元素在map中是否存在
        for (int n : nums2) {
            int cnt = map.getOrDefault(n, 0);
            // 若存在且计数为正，将元素拷贝到nums1[k]，且k++；减少map中对应元素的计数
            if (cnt > 0) {
                nums1[k++] = n;
                map.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * 方法二：排序
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public static int[] intersectII(int[] nums1, int[] nums2) {

        // 对数组nums1和nums2排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 初始化指针i,j,k为0
        int i = 0, j = 0, k = 0;
        // 指针i指向nums1，指针j指向nums2
        while (i < nums1.length && j < nums2.length) {

            // 如果 nums1[i] < nums2[j]，则 i ++
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 如果 nums1[i] > nums2[j]，则 j ++
                j++;
            } else if (nums1[i] == nums2[j]) {
                // 如果 nums1[i] == nums2[j]，则将元素拷贝到nums1[k]，且 i ++, j ++, k ++
                nums1[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{1, 1};

        System.out.println(Arrays.toString(intersectI(nums1, nums2)));
        System.out.println(Arrays.toString(intersectII(nums1, nums2)));
    }

}
