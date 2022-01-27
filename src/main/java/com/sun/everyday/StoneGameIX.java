package com.sun.everyday;

/**
 * 【2029. 石子游戏 IX】
 * 🔗 https://leetcode-cn.com/problems/stone-game-ix/
 *
 * @author sunyl
 * @date 2022/1/20 10:03 AM
 * @see com.sun.everyday
 */
public class StoneGameIX {

    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }

}
