package com.sun.alogorithm.elementary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/12/28 10:40 上午
 * @see com.sun.alogorithm.elementary
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length, lastOne = digits[n - 1];
        if (lastOne + 1 < 10) {
            ++digits[n - 1];
            return digits;
        }
        int carry = 1;
        List<Integer> res = new ArrayList<>();
        res.add(0, 0);
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] + carry >= 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
            res.add(0, digits[i]);
        }
        if (1 == carry) {
            res.add(0, carry);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] plusOneBetter(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{8, 8, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }
}
