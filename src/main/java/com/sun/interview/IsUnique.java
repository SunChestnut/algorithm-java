package com.sun.interview;

/**
 * 面试题 01.01. 判定字符是否唯一
 *
 * @author syl
 * @date 2020/04/27 - 15:59
 */
public class IsUnique {

    public boolean isUnique(String astr) {
        char[] charArray = astr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUniqueT(String astr) {

        int[] arr = new int[26];

        for (char c : astr.toCharArray()) {
            int index = c - 'a';
            if (arr[index] == 0) {
                arr[index] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique solution = new IsUnique();
        System.out.println(solution.isUnique("leetcode"));
        System.out.println(solution.isUnique("abc"));

        System.out.println(solution.isUniqueT("leetcode"));
    }

}
