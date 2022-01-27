package com.sun.offer.middle;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/1/24 5:20 PM
 * @see com.sun.offer.middle
 */
public class Offer45 {

    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] sNums = new String[n];
        for (int i = 0; i < n; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }
        quickSort(sNums, 0, n - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(sNums[i]);
        }
        return builder.toString();
    }

    private static void quickSort(String[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, 0, p - 1);
        quickSort(nums, p + 1, r);
    }

    private static int partition(String[] nums, int l, int r) {
        int rand = (int) (Math.random() * (r - l + 1) + l);
        swap(nums, l, rand);
        String v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            String x = v + nums[i], y = nums[i] + v;
            if (x.compareTo(y) > 0) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, l, j);

        return j;
    }

    private static void swap(String[] nums, int a, int b) {
        String tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 使用内置排序算法进行排序
     *
     * @param nums
     * @return
     */
    public String minNumberWithInnerAlgorithm(int[] nums) {
        int n = nums.length;
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(array[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Offer45 solution = new Offer45();
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution.minNumberWithInnerAlgorithm(new int[]{3, 30, 34, 5, 9}));
    }

}
