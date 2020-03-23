package com.sun.algorithm.everyday;

/**
 * leetcode836. 矩形重叠
 *
 * @author syl
 * @date 2020/03/18 - 09:56
 */
public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec1.length <= 0 || rec2.length <= 0) {
            return false;
        }

        // 查找无交集的部分
        return !(rec1[2] <= rec2[0]
                || rec1[0] >= rec2[2]
                || rec1[3] <= rec2[1]
                || rec1[1] >= rec2[3]);
    }

    public static void main(String[] args) {
        RectangleOverlap solution = new RectangleOverlap();
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }
}
