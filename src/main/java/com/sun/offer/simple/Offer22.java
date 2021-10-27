package com.sun.offer.simple;

import lombok.ToString;

/**
 * @author sunyl
 * @date 2021/10/24 6:56 下午
 * @see com.sun.offer.simple
 */
public class Offer22 {

    @ToString
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Syl: 非双指针做法，先遍历单链表计算出单链表的长度，再根据条件中的倒数第 k 个节点
     * 的 k 值计算出从第几个节点开始返回
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEndA(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (null != p) {
            len++;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < len - k; i++) {
            p = p.next;
        }

        return p;
    }

    /**
     * 官方题解：同上述思路，但代码更简洁美观
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEndB(ListNode head, int k) {
        int len = 0;
        ListNode p;
        for (p = head; p != null; p = p.next) {
            len++;
        }
        for (p = head; len > k; len--) {
            p = p.next;
        }
        return p;
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast;
        for (fast = head; k > 0; k--) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(getKthFromEndA(head, 2).toString());
        System.out.println(getKthFromEndA(head, 3).toString());
        System.out.println(getKthFromEndA(new ListNode(1), 1).toString());

        System.out.println(getKthFromEndB(head, 2).toString());
        System.out.println(getKthFromEndB(head, 3).toString());
        System.out.println(getKthFromEndB(new ListNode(1), 1).toString());

        System.out.println(getKthFromEnd1(head, 2).toString());
        System.out.println(getKthFromEnd1(head, 3).toString());
        System.out.println(getKthFromEnd1(new ListNode(1), 1).toString());
    }

}
