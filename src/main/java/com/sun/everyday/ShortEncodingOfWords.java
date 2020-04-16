package com.sun.everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode820. 单词的压缩编码
 *
 * @author syl
 * @date 2020/03/28 - 08:58
 */
public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {

        Set<String> good = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); k++) {
                String substring = word.substring(k);
                good.remove(substring);
            }
        }

        int ans = 0;
        for (String word : good) {
            ans += word.length() + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortEncodingOfWords solution = new ShortEncodingOfWords();
        System.out.println(solution.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
}
