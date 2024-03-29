package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
 * ----------------------------------------------------------
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/6/27 15:54
 **/
class ZigZagConversion {

    static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }


    static String convertT(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> builderList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            builderList.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            builderList.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        // 拼接Z形字符结果
        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : builderList) {
            builder.append(row);
        }
        return builder.toString();
    }

}
