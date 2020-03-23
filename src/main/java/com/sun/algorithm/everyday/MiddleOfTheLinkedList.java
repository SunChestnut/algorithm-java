package com.sun.algorithm.everyday;

/**
 * leetcode876. 链表的中间结点
 *
 * @author syl
 * @date 2020/03/23 - 08:44
 */
public class MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int n = 0;
        int count = countLinkedList(head, n);

        ListNode cur = head;
        for (int i = 1; i <= count / 2; i++) {
            cur = cur.next;
        }

        return cur;
    }

    private int countLinkedList(ListNode head, int n) {
        if (head == null) {
            return n;
        }
        return countLinkedList(head.next, ++n);
    }

    /******************/
    public static ListNode createLinkedList(int[] array) {
        int n = array.length;
        if (n == 0) {
            return null;
        }

        // create head node
        ListNode head = new ListNode(array[0]);
        ListNode curNode = head;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(array[i]);
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * print single linked list
     *
     * @param head head node
     */
    public static void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        ListNode result1 = solution.middleNode(head1);
        ListNode result2 = solution.middleNode(head2);

        printLinkedList(result1);
        printLinkedList(result2);

    }

}
