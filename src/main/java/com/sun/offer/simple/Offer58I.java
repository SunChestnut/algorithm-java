package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2022/1/14 3:11 PM
 * @see com.sun.offer.simple
 */
public class Offer58I {

    public String reverseWords(String s) {
        s = s.trim();
        String[] array = s.split(" ");
        StringBuilder reverse = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!" ".equals(array[i]) && array[i].length() > 0) {
                reverse.append(array[i]).append(" ");
            }
        }
        return reverse.toString().trim();
    }

    public String reverseWordsWithDoublePointers(String s) {
        s = s.trim();
        int i = s.length() - 1, j = s.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            builder.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Offer58I solution = new Offer58I();
        System.out.println(solution.reverseWordsWithDoublePointers("a good   example"));
        System.out.println(solution.reverseWordsWithDoublePointers("the sky is blue"));
        System.out.println(solution.reverseWordsWithDoublePointers("  hello world!  "));
    }

}
