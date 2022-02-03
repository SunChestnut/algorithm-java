package com.sun.basic.bubblesort;

import com.sun.basic.SortTestHelper;

import java.util.Arrays;

/**
 * @author sunyl
 * @date 2022/1/30 3:44 PM
 * @see com.sun.basic.bubblesort
 */
public class BubbleSort {

public static void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[j - 1]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }
}

    public static void main(String[] args) {
        int[] nums = SortTestHelper.generateRandomArray(10, 0, 20);
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
