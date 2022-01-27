package com.sun.offer.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 【剑指 Offer 48. 最长不含重复字符的子字符串】
 * 🔗 https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * @author sunyl
 * @date 2022/1/20 11:36 AM
 * @see com.sun.offer.middle
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        // 使用哈希表统计各字符最后一次出现索引的位置
        Map<Character, Integer> memo = new HashMap<>(s.length());
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = memo.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            memo.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        Offer48 solution = new Offer48();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

}
