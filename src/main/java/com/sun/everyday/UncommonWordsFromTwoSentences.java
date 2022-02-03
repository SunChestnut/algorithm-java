package com.sun.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【884. 两句话中的不常见单词】
 * 🔗 https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 *
 * @author sunyl
 * @date 2022/1/30 10:02 AM
 * @see com.sun.everyday
 */
public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>(s1.length());
        putInMap(map, s1);
        putInMap(map, s2);

        List<String> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == 1) {
                res.add(k);
            }
        });
        return res.toArray(new String[0]);
    }

    private void putInMap(Map<String, Integer> map, String s) {
        for (String v : s.split(" ")) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
    }

}
