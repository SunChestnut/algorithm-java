package com.sun.solution.simple;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: 121
 * 输出: true
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * ----------------------------------------------------------
 * 🧐进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * ----------------------------------------------------------
 *
 * @author: syl
 * @date: 2019/7/9 16:58
 **/
class PalindromeNumber {

    /**
     * 解法一：将数字转换成字符串
     *
     * @param x x
     * @return boolean
     */
    static boolean isPalindromeMethodI(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        String[] array = str.split("");
        int j = array.length - 1;
        for (int i = 0; i < array.length; ) {
            if (array[i].equals(array[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 原理同解法一，不同点在于使用StringBuilder做字符串反转
     *
     * @param x x
     * @return boolean
     */
    static boolean isPalindromeMethodII(int x) {
        String reversedStr = (new StringBuilder(x + "").reverse().toString());
        return (x + "").equals(reversedStr);
    }

    /**
     * 解法二：通过取余和取整来判断
     * ----------------------------------------------------------
     * 举例：1221
     * a.计算 1221 / 1000  = 1
     * b.计算 1221 % 10 = 1
     * c.判断 1 == 1 ？true : false
     * d.以此类推
     * ----------------------------------------------------------
     *
     * @param x x
     * @return boolean
     */
    static boolean isPalindromeMethodIII(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right) {
                return false;
            }

            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 解法四：将数字折半，对比前半部分和后半部分
     * ----------------------------------------------------------
     * a.每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * b.将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * c.每取一个最低位数字，x 都要自除以 10
     * d.判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * e.判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     * ----------------------------------------------------------
     *
     * @param x x
     * @return boolean
     */
    static boolean isPalindromeMethodIV(int x) {
        // 当x为负数或者x的最后一位为0时，直接返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
