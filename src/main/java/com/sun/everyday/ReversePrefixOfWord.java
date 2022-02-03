package com.sun.everyday;

/**
 * 【2000. 反转单词前缀】
 * 🔗 https://leetcode-cn.com/problems/reverse-prefix-of-word/
 *
 * @author sunyl
 * @date 2022/2/2 5:27 PM
 * @see com.sun.everyday
 */
public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return word;
        }
        String sub = word.substring(0, index + 1);
        StringBuilder reverse = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            reverse.append(sub.charAt(i));
        }
        return reverse.append(word.substring(index + 1)).toString();
    }

}
