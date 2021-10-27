package com.sun.offer.simple;

import lombok.ToString;

/**
 * @author sunyl
 * @date 2021/10/24 6:33 下午
 * @see com.sun.offer.simple
 */
public class Offer18 {

    @ToString
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        while (null != p.next) {
            ListNode tmp = p;
            p = p.next;
            if (p.val == val) {
                tmp.next = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println(deleteNode(head, 5).toString());
    }

}
