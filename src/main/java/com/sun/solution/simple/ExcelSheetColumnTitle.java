package com.sun.solution.simple;

/**
 * 168. Excel表列名称
 *
 * @author syl
 * @date 2020/04/22 - 09:51
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        StringBuilder res = new StringBuilder();

        while (n > 0) {
            n -= 1;
            System.out.println(n + " % 26 = " + n % 26);
            res.insert(0, (char) ('A' + (n % 26)));
            n /= 26;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
        System.out.println(solution.convertToTitle(701));
    }

}
