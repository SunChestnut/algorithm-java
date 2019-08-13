package com.sun.algorithm.solution;

/**
 * TODO
 *
 * @Author: syl
 * @Date: 2019/8/13 9:12
 **/
class SolutionEight {

    /**
     * 1.删除字符串中的子空串
     * 2.判断第一个非空子串是否为数字
     * 3.判断数字的大小是否超过最大限制
     */
    private static int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        final int n = str.length();
        if (n == 0) {
            return 0;
        }

        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        for (; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 &&
                            (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + str.charAt(i) - '0';
        }
        return num * sign;
    }
}
