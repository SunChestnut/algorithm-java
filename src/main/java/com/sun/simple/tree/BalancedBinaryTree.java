package com.sun.simple.tree;

/**
 * 【110. 平衡二叉树】
 * 🔗 https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author sunyl
 * @date 2022/2/8 3:03 PM
 * @see com.sun.simple.tree
 */
public class BalancedBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
