package com.sun.interview;

/**
 * 面试题24. 反转链表
 *
 * @author syl
 * @date 2020/05/07 - 10:05
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        ListNode curHead = head;

        while (curHead != null) {
            ListNode next = curHead.next;
            curHead.next = newHead;
            newHead = curHead;
            curHead = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        for (int value : arr) {
            curNode.next = new ListNode(value);
            curNode = curNode.next;
        }


        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode cur2 = solution.reverseList(head.next);
        System.out.println(cur2.toString());
    }

}
