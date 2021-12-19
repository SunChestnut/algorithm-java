package com.sun.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/11/15 5:56 下午
 * @see com.sun.datastructure
 */
public class YangHuiTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(rows);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

}
