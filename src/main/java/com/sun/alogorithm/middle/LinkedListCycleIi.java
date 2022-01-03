package com.sun.alogorithm.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/12/30 1:55 下午
 * @see com.sun.alogorithm.middle
 */
public class LinkedListCycleIi {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode k = head;
        while (k != null) {
            if (!visited.add(k)) {
                return k;
            }
            k = k.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        LinkedListCycleIi solution = new LinkedListCycleIi();
        System.out.println(solution.detectCycle(head).val);
    }

}
