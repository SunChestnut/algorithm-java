package com.sun.solution.simple;

import java.util.*;

/**
 * leetcode 870. 优势洗牌
 *
 * @author syl
 * @date 2020/04/17 - 09:53
 */
public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {

        int[] sortA = A.clone();
        Arrays.sort(sortA);

        int[] sortB = B.clone();
        Arrays.sort(sortB);

        // assigned[b] = 所有能打败元素b的集合
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int v : B) {
            assigned.put(v, new LinkedList<>());
        }

        // remaining = 未被给任何b的元素
        Deque<Integer> remaining = new LinkedList<>();

        int j = 0;
        for (int a : sortA) {
            if (a > sortB[j]) {
                assigned.get(sortB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {

            if (assigned.get(B[i]).size() > 0) {
                ans[i] = assigned.get(B[i]).pop();
            } else {
                ans[i] = remaining.pop();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};

        AdvantageShuffle solution = new AdvantageShuffle();
        int[] res = solution.advantageCount(A, B);
        System.out.println(Arrays.toString(res));
    }

}
