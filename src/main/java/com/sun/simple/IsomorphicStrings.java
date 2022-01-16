package com.sun.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2022/1/6 2:24 下午
 * @see com.sun.simple
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) {
            return false;
        }
        Map<Character, Character> sMapT = new HashMap<>(lenS);
        Map<Character, Character> tMapS = new HashMap<>(lenT);
        for (int i = 0; i < lenS; i++) {
            char a = s.charAt(i), b = t.charAt(i);
            boolean notMapT = sMapT.containsKey(a) && sMapT.get(a) != b;
            boolean notMapS = tMapS.containsKey(b) && tMapS.get(b) != a;
            if (notMapT || notMapS) {
                return false;
            }
            sMapT.put(a, b);
            tMapS.put(b, a);
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic("badc", "baba"));
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
    }
}
