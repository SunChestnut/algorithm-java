package com.sun.offer.simple;

/**
 * 【剑指 Offer 55 - I. 二叉树的深度】
 * 🔗 https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * @author sunyl
 * @date 2022/1/26 9:57 AM
 * @see com.sun.offer.simple
 */
public class Offer55I {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Offer55I solution = new Offer55I();
        System.out.println(solution.maxDepth(root));
    }

}
