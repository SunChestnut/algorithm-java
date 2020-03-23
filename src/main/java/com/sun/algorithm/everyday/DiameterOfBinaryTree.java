package com.sun.algorithm.everyday;

/**
 * 543. 二叉树的直径
 *
 * @author syl
 * @date 2020/03/10 - 10:16
 */
public class DiameterOfBinaryTree {

    int maxDepth;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth = 1;
        depth(root);
        return maxDepth - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        maxDepth = Math.max(maxDepth, l + r + 1);

        return Math.max(l, r) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

}
