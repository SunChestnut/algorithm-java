package com.sun.offer.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunyl
 * @date 2021/10/20 9:54 上午
 * @see com.sun.offer.simple
 */
public class Offer32II {

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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();

            // 这个 for 循环纠结了好久，为什么 for 循环内向 queue 中添加了元素，但是 for 循环却可以正确的终止呢？
            // 这个问题的答案也是 for 循环为什么要从 queue 的原因
            // 插个点，不要看 for 循环中变量 i 的初始值设置的是 queue 的长度，就以为要从队列的尾端开始遍历，这个 for 循环只限制了循环的次数，变量 i 的值在循环体中并未使用到
            // 回答上个问题，变量 i 的初始值只在声明时赋值一次，即使循环内部更改了队列的长度，变量 i 的初始值也不会再更改
            // 如果你把 for 循环写成：for(int i = 0;i < queue.length;i++) 情况可就不一样咯
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
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

        System.out.println(levelOrder(root));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        for (int i = queue.size(); i > 0; i--) {
            System.out.println(queue.poll());
        }

    }

}
