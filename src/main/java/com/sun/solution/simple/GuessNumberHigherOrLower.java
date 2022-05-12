package com.sun.solution.simple;

/**
 * 374. 猜数字大小
 *
 * @author syl
 * @date 2020/05/13 - 08:37
 */
public class GuessNumberHigherOrLower {

    /*
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */


    private int guess(int num) {
        int pick = 9;
        return Integer.compare(pick, num);
    }

    public int guessNumber(int n) {

        int l = 1, r = n, mid = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == -1) {
                r = mid - 1;
            }
            if (guess(mid) == 1) {
                l = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower solution = new GuessNumberHigherOrLower();
        System.out.println(solution.guessNumber(10));
    }
}
