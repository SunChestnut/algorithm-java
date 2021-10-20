package com.sun.offer.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunyl
 * @date 2021/10/19 9:46 下午
 * @see com.sun.offer.middle
 */
public class Offer32I {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> valueList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            valueList.add(node.val);
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }
        }

        int[] res = new int[valueList.size()];
        for (int i = 0; i < valueList.size(); i++) {
            res[i] = valueList.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(10);

        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        node2.left = node6;
        node2.right = node7;

        System.out.println(Arrays.toString(levelOrder(root)));
    }

}
