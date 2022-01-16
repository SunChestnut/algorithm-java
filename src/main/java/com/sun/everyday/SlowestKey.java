package com.sun.everyday;

/**
 * @author sunyl
 * @date 2022/1/9 10:30 上午
 * @see com.sun.everyday
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int diff = releaseTimes[0];
        char lastLonger = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int sub = releaseTimes[i] - releaseTimes[i - 1];
            if (sub > diff) {
                diff = sub;
                lastLonger = keysPressed.charAt(i);
            } else if (sub == diff) {
                if (lastLonger < keysPressed.charAt(i)) {
                    lastLonger = keysPressed.charAt(i);
                }
            }
        }
        return lastLonger;
    }

    public static void main(String[] args) {
        SlowestKey solution = new SlowestKey();
        System.out.println(solution.slowestKey(new int[]{23, 34, 43, 59, 62, 80, 83, 92, 97}, "qgkzzihfc"));
        System.out.println(solution.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(solution.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }
}
