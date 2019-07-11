package com.sun;

import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author: syl
 * @date: 2019/7/9 15:17
 **/
public class TestCon {

    public static void main(String[] args) {
        String pattern = "^\\d+(\\.\\d+)?$";
        String a = "/^\\d+(\\.\\d+)?$/";
        String str = "12";
        boolean flag = Pattern.matches(a, str);
        System.out.println(flag);
    }
}
