package com.sun.everyday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 * @author sunyl
 * @date 2022/1/18 9:52 PM
 * @see com.sun.everyday
 */
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            // 相邻时间的时间差
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }
        // 排序后的时间，最小时间差出现在相邻或首尾的时间差中
        // 首尾时间差
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes);
        return ans;
    }

    private int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
        String s = "23:30";
        LocalDateTime time = LocalDate.parse(s, formatter).atStartOfDay();
        System.out.println(time);
    }
}
