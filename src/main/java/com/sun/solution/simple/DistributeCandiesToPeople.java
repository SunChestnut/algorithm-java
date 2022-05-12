package com.sun.solution.simple;

import java.util.Arrays;

/**
 * 1103. 分糖果 II
 *
 * @author syl
 * @date 2020/03/05 - 15:10
 */
public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {

        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = new DistributeCandiesToPeople().distributeCandies(7, 4);
        System.out.println(Arrays.toString(res));
    }

}
