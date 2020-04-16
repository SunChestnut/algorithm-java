package com.sun.everyday;

/**
 * leetcode914. 卡牌分组
 *
 * @author syl
 * @date 2020/03/27 - 09:33
 */
public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {

        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public static void main(String[] args) {
        XOfAKindInADeckOfCards solution = new XOfAKindInADeckOfCards();

//        System.out.println("true? " + solution.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
//
//        System.out.println("false? " + solution.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
//
//        System.out.println("false? " + solution.hasGroupsSizeX(new int[]{1}));
//
//        System.out.println("true? " + solution.hasGroupsSizeX(new int[]{1, 1}));
//
//        System.out.println("true? " + solution.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));

        System.out.println("true? " + solution.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

}
