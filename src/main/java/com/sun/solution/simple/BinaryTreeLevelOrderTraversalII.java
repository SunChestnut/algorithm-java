package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author syl
 * @date 2020/04/29 - 11:26
 */
public class BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> nodeList = new ArrayList<>();

    private void helper(TreeNode node, int level) {

        if (nodeList.size() == level) {
            nodeList.add(new ArrayList<>());
        }

        nodeList.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }

        if (node.right != null) {
            helper(node.right, level + 1);
        }

    }

    /**
     * 递归方式求解
     * @param root 根节点
     * @return BFS结果
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return nodeList;
        }

        helper(root, 0);

        Collections.reverse(nodeList);

        return nodeList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversalII solution = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> res = solution.levelOrderBottom(root);
        System.out.println(res.toString());

    }

}
