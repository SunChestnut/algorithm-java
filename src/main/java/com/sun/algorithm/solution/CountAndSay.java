package com.sun.algorithm.solution;

/**
 * TODO
 *
 * @author syl
 * @date 2020/01/30 - 15:11
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            s = getNext(s);
        }
        return s;
    }

    private static String getNext(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            int j = notEqual(s, i);
            builder.append(j - i);
            builder.append(s.charAt(i));
            i = j;
        }
        return builder.toString();
    }

    private static int notEqual(final String s, int fromIndex) {
        final char target = s.charAt(fromIndex);
        int i = fromIndex;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) != target) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }
}
