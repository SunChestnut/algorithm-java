package com.sun.offer.simple;

/**
 * 【剑指 Offer 25. 合并两个排序的链表】
 * 🔗 https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author sunyl
 * @date 2022/1/13 6:52 PM
 * @see com.sun.offer.simple
 */

public class Offer25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0), cur = dump;
        ListNode k1 = l1, k2 = l2;
        while (k1 != null && k2 != null) {
            if (k1.val < k2.val) {
                cur.next = new ListNode(k1.val);
                k1 = k1.next;
            } else {
                cur.next = new ListNode(k2.val);
                k2 = k2.next;
            }
            cur = cur.next;
        }
        cur.next = k1 == null ? k2 : k1;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);

        System.out.println(new Offer25().mergeTwoLists(l1, l2));
    }
}
