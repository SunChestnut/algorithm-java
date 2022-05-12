package com.sun.simple.tree;

/**
 * 【108. 将有序数组转换为二叉搜索树】
 * 🔗 https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author sunyl
 * @date 2022/2/8 2:41 PM
 * @see com.sun.simple.tree
 */
public class ConvertSortedArrayToBinarySearchTree {

    static class TreeNode {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10, 3, 0, 5, 9});
        System.out.println(root);
    }
}
