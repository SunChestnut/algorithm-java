package com.sun.solution.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author syl
 * @date 2020/04/28 - 10:26
 */
public class BinaryTreeLevelOrderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    private void helper(TreeNode node, int level) {

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return res;
        }

        helper(root, 0);

        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal solution1 = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> result1 = solution1.levelOrder(root);
        System.out.println(result1.toString());

        BinaryTreeLevelOrderTraversal solution2 = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> res2 = solution2.levelOrder(null);
        System.out.println(res2.toString());
    }

}
