package com.sun.offer.middle;

/**
 * ❗️
 *
 * @author sunyl
 * @date 2021/10/22 4:00 下午
 * @see com.sun.offer.middle
 */
public class Offer26 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 若树 B 是树 A 的子结构，则必须满足以下三种情况之一：
        // 以节点 A 为根节点的子树包含树 B
        // 树 B 是树 A 左子树的子结构
        // 树 B 是树 A 右子树的子结构
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recur(TreeNode A, TreeNode B) {
        // 已完成匹配
        if (null == B) {
            return true;
        }
        // 当 A 节点为空，说明已经越过树 A 叶子结点，匹配失败；
        // 当 A 节点的值与 B 节点的值不同，说明匹配失败
        if (null == A || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
