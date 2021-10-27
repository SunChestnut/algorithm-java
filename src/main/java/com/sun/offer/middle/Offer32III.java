package com.sun.offer.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/10/22 3:30 下午
 * @see com.sun.offer.middle
 */
public class Offer32III {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                // 偶数层
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (null != node.left) {
                    deque.add(node.left);
                }
                if (null != node.right) {
                    deque.add(node.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(levelOrder(root));
    }
}
