package com.sun.everyday;

/**
 * 【1576. 替换所有的问号】
 * 🔗 https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 *
 * @author sunyl
 * @date 2022/1/5 9:33 上午
 * @see com.sun.everyday
 */
public class ReplaceAll {

    public String modifyString(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (letters[i] == '?') {
                for (char a = 'a'; a <= 'c'; a++) {
                    if ((i > 0 && letters[i - 1] == a) || (i < n - 1 && letters[i + 1] == a)) {
                        continue;
                    }
                    letters[i] = a;
                }
            }
        }
        return new String(letters);
    }

    public static void main(String[] args) {
        ReplaceAll solution = new ReplaceAll();
        System.out.println(solution.modifyString("ubv?w"));
    }

}
