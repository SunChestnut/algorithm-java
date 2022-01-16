package com.sun.offer.simple;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyl
 * @date 2021/10/26 11:20 上午
 * @see com.sun.offer.simple
 */
@Slf4j
public class Offer27 {

    @ToString
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static TreeNode mirrorTreeWithStack(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        log.info("Region Binary Tree : {}", printBinaryTree(root));

//        TreeNode node = mirrorTree(root);
//        System.out.println(printBinaryTree(node));

        TreeNode node1 = mirrorTreeWithStack(root);
        log.info("Mirror Result : {}", printBinaryTree(node1));
    }

    static List<Integer> printBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<Integer> tmp = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            tmp.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        return tmp;
    }

}
