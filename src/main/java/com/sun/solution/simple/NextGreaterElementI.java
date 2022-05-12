package com.sun.solution.simple;

import java.util.Arrays;

/**
 * TODO
 *
 * @author sunyl
 * @date 2022/5/9 14:25
 * @see com.sun.solution.simple
 */
public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[n1];
        int index = 0;
        for (int x : nums1) {
            for (int j = 0; j < n2; j++) {
                if (x == nums2[j]) {
                    int k = j + 1;
                    while (k < n2) {
                        if (nums2[k] > x) {
                            res[index++] = nums2[k];
                            break;
                        }
                        k++;
                    }
                    if (k == n2) {
                        res[index++] = -1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7});
        System.out.println(Arrays.toString(res));
    }
}
