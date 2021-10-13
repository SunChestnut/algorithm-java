package com.sun.offer.simple;

import lombok.ToString;

/**
 * @author sunyl
 * @date 2021/10/13 12:36 下午
 * @see com.sun.offer
 */
public class Offer24 {

    @ToString
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode node = reverseList(head);
        System.out.println(node.toString());
    }
}
