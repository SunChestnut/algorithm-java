package com.sun.offer.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/10/14 4:01 下午
 * @see com.sun.offer.simple
 */
public class Offer03 {

    public static int findRepeatNumberA(int[] nums) {
        /**
         * 最初我的解题思路也是一样的，但是我使用了 List 作为额外的数据空间，结果超时了……
         * 为什么使用 Set 没问题呢？
         * 在 if 条件判断待存入集合值是否已存在于集合中时，Set 只需一步操作，就是直接添加，如果添加成功，则表示该值不存在于集合中，相反，则添加失败
         * 而使用 List 需要两步操作，先判断待存入集合的值是否已经存在于集合中，如果不存在，执行添加操作
         */
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (Integer num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static int findRepeatNumber(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        final int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        for (int i = 0, j = 1; i < n - 1 && j < n; i++, j++) {
            if (sortedNums[i] == sortedNums[j]) {
                return sortedNums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumberA(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
