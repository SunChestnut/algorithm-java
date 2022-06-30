package com.sun.offerII;

/**
 * <a href="https://leetcode.cn/problems/XltzEq/">🔗【剑指 Offer II 018. 有效的回文】</a>
 *
 * @author sunyl
 * @date 2022/6/23 10:50
 * @see com.sun.offerII
 */
public class Solution018 {

    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 1 && " ".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0, r = n - 1;
        while (l <= r) {
            if (!Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))) {
                l++;
            } else if (!(Character.isDigit(s.charAt(r)) || Character.isLetter(s.charAt(r)))) {
                r--;
            } else if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                System.out.println(s.charAt(l) + "," + s.charAt(r));
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeBetter(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (!String.valueOf(s.charAt(l)).equalsIgnoreCase(String.valueOf(s.charAt(r)))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution018 solution = new Solution018();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));

        System.out.println(solution.isPalindromeBetter("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindromeBetter("race a car"));
    }

}
