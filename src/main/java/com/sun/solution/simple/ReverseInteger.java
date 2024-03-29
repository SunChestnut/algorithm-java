package com.sun.solution.simple;

import java.text.DecimalFormat;

/**
 * 题目：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/26 10:08
 **/
class ReverseInteger {

    static int reverse(int x) {
        DecimalFormat df = new DecimalFormat("0");
        String strNum = String.valueOf(x);
        String[] strings = strNum.split("");
        int n = strings.length;
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if ("-".equals(strings[i])) {
                builder.insert(0, strings[i]);
            } else {
                builder.append(strings[i]);
            }
        }
        if ("".equals(builder.toString())) {
            return 0;
        }
        if ("-".equals(String.valueOf(builder.charAt(0)))) {
            if (builder.length() >= 11 && Long.parseLong(builder.toString()) < Long.parseLong("-" + df.format(Math.pow(2, 31)))) {
                return 0;
            }
        }
        if (!"-".equals(String.valueOf(builder.charAt(0)))) {
            if (builder.length() >= 10 && Long.parseLong(builder.toString()) > Long.parseLong(df.format(Math.pow(2, 31)))) {
                return 0;
            }
        }
        return Integer.parseInt(builder.toString());
    }
}
