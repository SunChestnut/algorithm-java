package com.sun.everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 【1996. 游戏中弱角色的数量】
 * 🔗 https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/submissions/
 *
 * @author sunyl
 * @date 2022/1/28 9:58 AM
 * @see com.sun.everyday
 */
public class TheNumberOfWeakCharactersInTheGame {

    public static int numberOfWeakCharacters(int[][] properties) {
        // 将二维数组排序，如果攻击值相同，则按照防御值的升序排序，如果攻击值不同，则按照攻击值的降序排序
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]));
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int[] p : properties) {
            System.out.println("deque.peek = " + deque.peek());
            System.out.println("p[1] = " + p[1]);
            // 弱角色
            while (!deque.isEmpty() && deque.peek() < p[1]) {
                deque.pop();
                ans++;
            }
            deque.push(p[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] properties = {
                {1, 5}, {10, 4}, {4, 3}
        };
        System.out.println(numberOfWeakCharacters(properties));
    }

}
