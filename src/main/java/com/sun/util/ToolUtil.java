package com.sun.util;

import java.util.Date;

/**
 * 工具类
 *
 * @author: syl
 * @date: 2019/6/18 17:34
 **/
public class ToolUtil {

    /**
     * 计算方法运行时间
     *
     * @param date 方法开始运行的时间
     * @return 耗费的总时长
     */
    public static String runTime(Date date) {
        long time = System.currentTimeMillis() - date.getTime();
        Double value = (double) time / 1000;
        return String.valueOf(value);
    }
}
