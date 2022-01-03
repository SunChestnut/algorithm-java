package com.sun.alogorithm.elementary;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/12/29 8:54 下午
 * @see com.sun.alogorithm.elementary
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode k = head;
        while (k != null) {
            if (!nodeSet.add(k)) {
                return true;
            }
            k = k.next;
        }
        return false;
    }

    public boolean hasCycleBetter(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(head));
        System.out.println(solution.hasCycleBetter(head));
    }

}
