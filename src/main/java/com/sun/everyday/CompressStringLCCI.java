package com.sun.everyday;

/**
 * 面试题 01.06. 字符串压缩
 *
 * @author syl
 * @date 2020/03/16 - 09:13
 */
public class CompressStringLCCI {

    public String compressString(String S) {
        // 处理空串
        if (S.length() == 0) {
            return S;
        }

        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        // 记录当前要压缩的字符
        char ch = S.charAt(0);

        for (int i = 0; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                builder.append(ch).append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }

        builder.append(ch).append(cnt);
        return builder.length() >= S.length() ? S : builder.toString();
    }

    public static void main(String[] args) {
        CompressStringLCCI solution = new CompressStringLCCI();
        System.out.println(solution.compressString("bbbac"));
        System.out.println(solution.compressString("a"));
        System.out.println(solution.compressString("aabcccccaaa"));
    }
}
