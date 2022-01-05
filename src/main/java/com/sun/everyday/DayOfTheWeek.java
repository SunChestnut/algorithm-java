package com.sun.everyday;

/**
 * @author sunyl
 * @date 2022/1/3 9:34 上午
 * @see com.sun.everyday
 */
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 4;
        // 计算 1971 年 ～ year 之间的天数
        for (int i = 1971; i < year; i++) {
            // 闰年分为普通闰年和世纪闰年：
            // 公里年份是 4 的倍数并且不是 100 的倍数的年份为普通闰年；公里年份是 400 的倍数为世纪闰年
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || (i % 400 == 0);
            ans += isLeap ? 366 : 365;
        }
        // 计算 [1,month-1] 经过了多少天
        for (int i = 1; i < month; i++) {
            ans += dayInMonth[i - 1];
            // 闰年的 二月份 有 29 天
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (i == 2 && isLeap) {
                ans++;
            }
        }
        // 计算 [1,day] 经过了多少天
        ans += day;
        System.out.println((ans + 3) % 4);
        return week[ans % 7];
    }

    public static void main(String[] args) {
        DayOfTheWeek solution = new DayOfTheWeek();
        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }
}
