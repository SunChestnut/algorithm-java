package com.sun.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/12/4 11:02 上午
 * @see com.sun.offerII
 */
public class Solution003 {

    /**
     * 暴力解
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        List<Integer> countOneList = new ArrayList<>();
        countOneList.add(0);
        for (int i = 1; i <= n; i++) {
            // 将每个数字都转换成二进制
            String binaryString = Integer.toBinaryString(i);
            // 计算二进制中 1 的个数
            int countOne = 0;
            for (Character c : binaryString.toCharArray()) {
                if (c == '1') {
                    countOne++;
                }
            }
            countOneList.add(countOne);
        }
        return countOneList.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 对从 0 到 n 的每个整数直接计算「一比特数」
     * <p>
     * Brian Kernighan 算法：对于任意整数 x ，令 x = x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0 ，该操作次数即为 x 的「一比特数」
     *
     * @param n
     * @return
     */
    public int[] countBitsBrianKernighan(int n) {
        int[] countBis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            countBis[i] = countOne(i);
        }
        return countBis;
    }

    public int countOne(int n) {
        int countRes = 0;
        while (n > 0) {
            n &= n - 1;
            countRes++;
        }
        return countRes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(0)));
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));

        System.out.println("#####################");

        Solution003 solution = new Solution003();
        System.out.println(Arrays.toString(solution.countBitsBrianKernighan(0)));
        System.out.println(Arrays.toString(solution.countBitsBrianKernighan(2)));
        System.out.println(Arrays.toString(solution.countBitsBrianKernighan(5)));
    }
}
