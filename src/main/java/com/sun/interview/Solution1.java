package com.sun.interview;

/**
 * 【长按键入】
 *
 * @author sunyl
 * @date 2021/12/31 10:43 上午
 * @see com.sun.interview
 */
public class Solution1 {

    public boolean isLongPressedName(String name, String typed) {
        int nLength = name.length(), tLength = typed.length();
        if (nLength > tLength) {
            return false;
        }
        int i = 0, j = 0;
        while (j < tLength) {
            if (i < nLength && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == nLength;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(solution.isLongPressedName("rick", "kric"));
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
    }

}
