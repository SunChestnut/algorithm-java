package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 94. 二叉树的中序遍历
 *
 * @author syl
 * @date 2020/04/16 - 20:58
 */
public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }

    public static void main(String[] args) {

        // 构造二叉树
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> res = solution.inorderTraversal(head);
        System.out.println(res.toString());
    }

}
