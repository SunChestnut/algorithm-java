package com.sun.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author syl
 * @date 2020/04/26 - 10:11
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // 第一行永远为1
        triangle.add(Collections.singletonList(1));

        for (int n = 1; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(n - 1);

            // 第一个元素永远为1
            row.add(1);

            for (int j = 1; j < n; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            // 最后一个元素永远为1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        List<List<Integer>> res = solution.generate(5);
        System.out.println(res.toString());
    }

}
