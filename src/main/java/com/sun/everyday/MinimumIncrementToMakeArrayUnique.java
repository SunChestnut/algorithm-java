package com.sun.everyday;

import java.util.*;

/**
 * leetcode945. 使数组唯一的最小增量
 *
 * @author syl
 * @date 2020/03/22 - 09:15
 */
public class MinimumIncrementToMakeArrayUnique {

    /**
     * 超时 ❗️
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {

        Map<Integer, Integer> elements = new HashMap<>(16);
        Set<Integer> items = new HashSet<>();

        for (int value : A) {
            elements.put(value, elements.getOrDefault(value, 0) + 1);
            items.add(value);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            if (entry.getValue() > 1) {
                int key = entry.getKey(), value = entry.getValue();
                while (--value > 0) {
                    count += 1;
                    while (items.contains(++key)) {
                        count++;
                    }
                    items.add(key);
                    key = entry.getKey();
                }

            }
        }
        return count;
    }

    public int xxx(int[] A) {
        Arrays.sort(A);
        int ans = 0, taken = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * A[i - 1];
                taken -= give;
            }
        }

        if (A.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();
    }
}
