package com.sun.goldcode;

/**
 * @author sunyl
 * @date 2021/12/2 7:12 下午
 * @see com.sun.goldcode
 */
public class StringToUrl {

    public static String replaceSpaces(String S, int length) {
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (length > 0) {
            if (S.charAt(index) == ' ') {
                builder.append("%20");
            } else {
                builder.append(String.valueOf(S.charAt(index)));
            }
            index++;
            length--;
        }
        return builder.toString();
    }

    public static String replaceSpacesWithCharArray(String S, int length) {
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (' ' == chars[i]) {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("               ", 5));

        System.out.println(replaceSpacesWithCharArray("Mr John Smith    ", 13));
        System.out.println(replaceSpacesWithCharArray("               ", 5));
        System.out.println(replaceSpacesWithCharArray("a bcd e f         888", 13));
    }

}
