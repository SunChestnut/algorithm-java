package com.sun.goldcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sunyl
 * @date 2021/12/2 10:42 上午
 * @see com.sun.goldcode
 */
public class CheckPermutation {

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }

    /**
     * 性能太差！！！
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationWithHash(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> countS1 = new HashMap<>(s1.length());
        Map<Character, Integer> countS2 = new HashMap<>(s2.length());
        for (Character c1 : s1.toCharArray()) {
            countS1.put(c1, countS1.getOrDefault(c1, 0) + 1);
        }
        for (Character c2 : s2.toCharArray()) {
            countS2.put(c2, countS2.getOrDefault(c2, 0) + 1);
        }
        for (Map.Entry<Character, Integer> temp : countS1.entrySet()) {
            if (!countS2.containsKey(temp.getKey()) || !Objects.equals(countS2.get(temp.getKey()), temp.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abc", "bad"));
        System.out.println(checkPermutation("abc", ""));

        System.out.println("- - - - -- - - - -- ");

        System.out.println(checkPermutationWithHash("abc", "bca"));
        System.out.println(checkPermutationWithHash("abc", "bad"));
        System.out.println(checkPermutationWithHash("abc", ""));
    }

}
