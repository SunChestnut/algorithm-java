package com.sun.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/11/8 8:36 上午
 * @see com.sun.datastructure
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> sortedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i == m) {
                sortedList.add(nums2[j++]);
            } else if (j == n) {
                sortedList.add(nums1[i++]);
            } else if (nums1[i] < nums2[j]) {
                sortedList.add(nums1[i++]);
            } else {
                sortedList.add(nums2[j++]);
            }
        }
        for (int k = 0; k < sortedList.size(); k++) {
            nums1[k] = sortedList.get(k);
        }
    }

    public static void mergeReverse(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, tail = m + n - 1;
        int cur;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                cur = nums2[j--];
            } else {
                cur = nums1[i--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        mergeReverse(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
