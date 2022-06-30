package com.sun.interview;

/**
 * 【面试题 01.06. 字符串压缩】
 * <p>
 * 🔗 <a href="https://leetcode.cn/problems/compress-string-lcci/">...</a>
 *
 * @author sunyl
 * @date 2022/5/23 09:43
 * @see com.sun.interview
 */
public class CompressString {

    public static String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        int count = 0, index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                builder.append(String.valueOf(S.charAt(i)));
                count++;
                continue;
            }
            if (S.charAt(i) == builder.charAt(index)) {
                count++;
            } else {
                builder.append(count);
                builder.append(String.valueOf(S.charAt(i)));
                count = 1;
                index++;
                while (index < builder.length()) {
                    if (Character.isDigit(builder.charAt(index))) {
                        index++;
                    } else {
                        break;
                    }
                }
            }
        }
        builder.append(count);
        return builder.length() >= S.length() ? S : builder.toString();
    }

    public static String compressStringBetter(String S) {
        if (S.length() == 0) {
            return S;
        }
        StringBuilder ans = new StringBuilder();
        // ch 记录当前要压缩的字符，cnt 记录 ch 出现的次数
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == ch) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                cnt = 1;
                ch = S.charAt(i);
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(CompressString.compressStringBetter("aabcccccaaa").equals("a2b1c5a3"));
        System.out.println(CompressString.compressStringBetter("abbccd").equals("abbccd"));
        System.out.println(CompressString.compressStringBetter("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff").equals("r5L5P6R5g3N5V10D10I10l7A4q7b3N4f6"));
    }

}
