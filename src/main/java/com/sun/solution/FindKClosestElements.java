package com.sun.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 *
 * @author syl
 * @date 2020/06/25 - 15:50
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int n = ret.size();

        // 如果x小于或等于数组中的第一个元素，则数组中的前k个元素就是答案
        if (x <= ret.get(0)) {
            return ret.subList(0, k);

            // 如果x大于或等于数组中的最后一个元素，则数组中的后k个元素就是答案
        } else if (x >= ret.get(n - 1)) {
            return ret.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ret, x);
            if (index < 0) {
                // 将index置为0
                index = -index - 1;
            }

            int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x)) {
                    high--;
                } else if ((x - ret.get(low)) > (ret.get(high) - x)) {
                    low++;
                } else {
                    System.out.println("unhandled case: " + low + " " + high);
                }
            }
            return ret.subList(low, high + 1);
        }
    }


}
