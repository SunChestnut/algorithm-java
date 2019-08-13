package com.sun.algorithm.util;

import java.time.Duration;
import java.time.Instant;

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
     * @param startTime 方法开始运行的时间
     */
    public static void runTime(Instant startTime) {
        Instant endTime = Instant.now();
        long estimatedTime = Duration.between(startTime, endTime).toMillis();
        double transformToS = (double) estimatedTime / 1000;
        System.out.println("代码执行共消耗：" + transformToS + "s");
    }
}
