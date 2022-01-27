package com.sun.offer.simple;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 【剑指 Offer 40. 最小的k个数】
 * 🔗 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author sunyl
 * @date 2022/1/25 10:23 AM
 * @see com.sun.offer.simple
 */
public class Offer40 {

    /**
     * 方法一：利用内置函数将数组排序，截取排序后的前 k 个元素
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    /**
     * 方法二：逻辑同【方法一】，但将内置数组替换为【快速排序】
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbersWithQs(int[] arr, int k) {
        return null;
    }

    public static int[] getLeastNumbersWithHeap(int[] arr, int k) {
        int[] res = new int[k];
        if (0 == k) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        System.out.println(queue);
        for (int i = k + 1; i < arr.length; i++) {
            if (queue.peek() != null && queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            Integer top = queue.poll();
            if (top != null) {
                res[i] = top;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = getLeastNumbersWithHeap(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(Arrays.toString(res));
    }

}
