package com.sun.everyday;

/**
 * @author sunyl
 * @date 2022/1/2 11:03 上午
 * @see com.sun.everyday
 */
public class EliminationGame {

    public int lastRemaining(int n) {
        // 等差数列的首字母为 a1，末尾元素为 an
        int a1 = 1, an = n;
        // 经过 k 次删除，元素数目为 cnt，公差为 step
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {

            // k 为偶数时，从左向右删除
            if (k % 2 == 0) {
                a1 += step;
                // 如果元素数目为偶数，则只删除首端元素，否则两端元素都会被删除
                an = (cnt % 2 == 0) ? an : an - step;

                // k 为奇数时，从右向左删除
            } else {
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
                an = an - step;
            }
            k++;
            // 右移运算符，移动一次相当于 除以 2
            cnt = cnt >> 1;
            // 左移运算符，移动一次相当于 乘以 2
            step = step << 1;
        }
        return a1;
    }

    public static void main(String[] args) {
        EliminationGame solution = new EliminationGame();
        System.out.println(solution.lastRemaining(9));
    }
}
