package com.sun.solution.simple;

/**
 * 1309. 解码字母到整数映射
 *
 * @author syl
 * @date 2020/04/23 - 09:27
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {

        Character[] arr = new Character[26];

        int num = 97;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) num++;
        }


        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n; ) {
            int j = i + 2;
            if (j < n && charArray[j] == '#') {
                int indexA = Integer.parseInt(charArray[i] + "" + charArray[i + 1]);
                builder.append(arr[indexA - 1]);
                i += 3;
            } else if (charArray[i] != '#') {
                int indexB = Integer.parseInt(charArray[i] + "");
                builder.append(arr[indexB - 1]);
                i++;
            }
        }

        return builder.toString();

    }

    public static void main(String[] args) {
        DecryptStringFromAlphabetToIntegerMapping solution = new DecryptStringFromAlphabetToIntegerMapping();
        System.out.println("abcdefghijklmnopqrstuvwxyz".equals(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")));
    }
}
