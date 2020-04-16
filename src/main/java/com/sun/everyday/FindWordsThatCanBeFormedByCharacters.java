package com.sun.everyday;

import java.util.HashMap;

/**
 * leetcode1160. 拼写单词
 *
 * @author syl
 * @date 2020/03/17 - 19:26
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {

        if (chars.length() == 0 || words.length == 0) {
            return 0;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (Character c : chars.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (String value : words) {
            HashMap<Character, Integer> wordCnt = new HashMap<>();
            for (Character character : value.toCharArray()) {
                wordCnt.put(character, wordCnt.getOrDefault(character, 0) + 1);
            }

            boolean isAns = true;
            for (Character character : value.toCharArray()) {
                if (!charMap.containsKey(character) || charMap.get(character) < wordCnt.get(character)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += value.length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        FindWordsThatCanBeFormedByCharacters solution = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(solution.countCharacters(words, chars));
    }
}
