package com.sun.solution.simple;

import java.util.Set;
import java.util.TreeSet;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author syl
 * @date 2020/04/04 - 14:23
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 要求删除元素时不改变原链表中元素的顺序，所以使用 TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        addValueToSet(head, set);

        ListNode node = new ListNode(0);
        ListNode cur = node;
        for (Integer value : set) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return node.next;
    }

    private void addValueToSet(ListNode head, Set<Integer> set) {
        if (head == null) {
            return;
        }

        set.add(head.val);
        addValueToSet(head.next, set);
    }


    // .......................

    public ListNode deleteDuplicatesBetter(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = {-3, -1, 0, 0, 0, 3, 3};
        ListNode head = new ListNode(array[0]);
        ListNode curNode = head;
        for (int i = 1; i < array.length; i++) {
            curNode.next = new ListNode(array[i]);
            curNode = curNode.next;
        }

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode resultNode = solution.deleteDuplicates(head);

        while (resultNode != null) {
            System.out.print(resultNode.val + " -> ");
            resultNode = resultNode.next;
        }
        System.out.println("null");
    }

}
