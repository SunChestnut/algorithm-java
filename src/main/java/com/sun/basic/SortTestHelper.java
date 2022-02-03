package com.sun.basic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试排序算法辅助类
 *
 * @author sunyl
 * @date 2022/1/27 3:28 PM
 * @see com.sun.basic
 */
@Slf4j
public class SortTestHelper {

    /**
     * SortTestHelper 不允许产生任何实例
     */
    private SortTestHelper() {
    }

    /**
     * 生成包含 n 个元素的整型数组，数组范围是[rangeL,rangeR]
     *
     * @param n      数组长度
     * @param rangeL 最小值
     * @param rangeR 最大值
     * @return 随机数组
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int v = (int) ((Math.random() * (rangeR - rangeL + 1)) + rangeL);
            nums[i] = v;
        }
        return nums;
    }

    /**
     * 生成近乎有序的数组
     *
     * @param n         数组元素个数
     * @param swapTimes 交换的次数
     * @return 随机数组
     */
    public static int[] generateNealyOrderedArray(int n, int swapTimes) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int randomX = (int) (Math.random() * n);
            int randomY = (int) (Math.random() * n);
            int tmp = res[randomX];
            res[randomX] = res[randomY];
            res[randomY] = tmp;
        }
        return res;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试算法的性能
     *
     * @param sortClassName 待测试的排序算法所在的类全称
     * @param arr           待排序数组
     */
    public static void testSort(String sortClassName, int[] arr) {
        try {
            final Class<?> sortClass = Class.forName(sortClassName);
            final Method sort = sortClass.getMethod("sort", int[].class);
            Object[] objs = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sort.invoke(null, objs);
            long endTime = System.currentTimeMillis();

            if (!isSorted(arr)) {
                log.error(sortClass.getSimpleName() + "排序失败~");
            }
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
