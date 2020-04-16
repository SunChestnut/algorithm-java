package com.sun.solution;

import java.util.Arrays;

/**
 * TODO
 *
 * @author syl
 * @date 2019/12/07 - 17:24
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] asStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrings, (String str1, String str2) -> {
            String order1 = str1 + str2;
            String order2 = str2 + str1;
            return order2.compareTo(order1);
        });

        if ("0".equals(asStrings[0])) {
            return "0";
        }

        StringBuilder largestNumberStr = new StringBuilder("");
        for (String numAsStr : asStrings) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 30, 34, 5, 9};
        String largestNumber = largestNumber(nums1);
        System.out.println("result = " + "9534330".equals(largestNumber));

        int[] nums2 = new int[]{10, 2};
        String result = largestNumber(nums2);
        System.out.println("result = " + "210".equals(result));
    }
}
