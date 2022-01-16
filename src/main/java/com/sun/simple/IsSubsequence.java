package com.sun.simple;

/**
 * @author sunyl
 * @date 2022/1/12 3:33 PM
 * @see com.sun.simple
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, n1 = s.length(), n2 = t.length();
        while (i < n1 && j < n2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n1;
    }

}
