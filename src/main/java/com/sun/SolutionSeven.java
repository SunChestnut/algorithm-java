package com.sun;

import com.sun.util.ToolUtil;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Date;

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
public class SolutionSeven {

    private static int reverse(int x) {
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
            if (builder.length() >= 11 && Long.valueOf(builder.toString()) < Long.valueOf("-" + df.format(Math.pow(2, 31)))) {
                return 0;
            }
        }
        if (!"-".equals(String.valueOf(builder.charAt(0)))) {
            if (builder.length() >= 10 && Long.valueOf(builder.toString()) > Long.valueOf(df.format(Math.pow(2, 31)))) {
                return 0;
            }
        }
        return Integer.valueOf(builder.toString());
    }

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        int num = -2147483412;
        System.out.println(reverse(num));
        ToolUtil.runTime(startTime);
    }
}
