package com.sun.alogorithm.elementary;

/**
 * @author sunyl
 * @date 2021/12/29 10:11 下午
 * @see com.sun.alogorithm.elementary
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        // 定义快指针和慢指针，当快指针到达终点（等于1），或者，快慢指针相遇时（进入循环后也会发生快慢指针相遇的情况），终止循环
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(6));
        System.out.println(solution.isHappy(65));
    }


}
