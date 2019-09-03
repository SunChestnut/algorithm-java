package com.sun.daily;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author: syl
 * @date: 2019/7/30 11:17
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration
public class DailyTest {

    @Test
    public void testA() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);

        System.out.println(list.size());

        System.out.println(list.get(4));
    }

    /**
     * 斐波拉契数列
     */
    @Test
    public void fibTest() {
        int n1 = 0, n2 = 1, n3, count = 10;
        System.out.println(n2);

        for (int i = 2; i < count; i++) {
            n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
    }

    @Test
    public void numberTest() {
        Pattern pattern = Pattern.compile("^\\d+$");
        String a = "4bc";

        Matcher m = pattern.matcher(String.valueOf(a.charAt(0)));
        System.out.println(m.matches());
    }

    @Test
    public void soutTime() {
        byte b1 = 1, b2 = 2, b3, b6, b8;
        final byte b4 = 4, b5 = 6, b7;


        final byte a1 = 1;
        final int a2 = 2;

        byte result1 = a1 + a2;
        int result2 = a1 + a2;

        Byte b = 3;
        System.out.println(b.getClass().getName());


        String a = "abc";
        System.out.println(a.getClass().getName());

    }

    @Test
    public void todayTest() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("abc");
        String abc = buffer.toString();

        System.out.println();

    }
}
