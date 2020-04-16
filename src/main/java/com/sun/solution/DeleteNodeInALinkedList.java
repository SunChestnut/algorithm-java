package com.sun.solution;

/**
 * leetcode 237: 删除链表中的节点
 *
 * @author syl
 * @date 2020/02/22 - 10:04
 */
public class DeleteNodeInALinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
            return;
        }

        // 将node节点的下一个节点值赋给node
        node.val = node.next.val;

        // 因为条件只给了待删除的节点，无法通过获取待删除的节点的前一个节点，通过改变待删除节点的前一个节点的指向，而成功删除待删除节点
        // 因此只能通过将待删除的节点的下一个节点值赋给待删除节点，然后删除待删除节点的下一个节点
        ListNode delNode = node.next;
        node.next = delNode.next;

    }
}
