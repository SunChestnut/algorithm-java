package com.sun.algorithm;

/**
 * @author sunyl
 * @date 2022/1/10 3:26 下午
 * @see com.sun.algorithm
 */
public class Solution {

    static class PrivateTreeNode {
        int val;
        PrivateTreeNode left;
        PrivateTreeNode right;

        PrivateTreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(PrivateTreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    private static boolean recur(PrivateTreeNode left, PrivateTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null) || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    public static void main(String[] args) {
        PrivateTreeNode root = new PrivateTreeNode(1);
        root.left = new PrivateTreeNode(2);
        root.right = new PrivateTreeNode(2);
        root.left.left = new PrivateTreeNode(3);
        root.left.right = new PrivateTreeNode(4);
        root.right.left = new PrivateTreeNode(4);
        root.right.right = new PrivateTreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
