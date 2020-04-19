package com.sun.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author syl
 * @date 2020/04/19 - 15:14
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Deque<Integer> d1 = new LinkedList<>();
        Deque<Integer> d2 = new LinkedList<>();

        ListNode cur1 = l1;
        while (cur1 != null) {
            d1.addFirst(cur1.val);
            cur1 = cur1.next;
        }

        ListNode cur2 = l2;
        while (cur2 != null) {
            d2.addFirst(cur2.val);
            cur2 = cur2.next;
        }

        System.out.println(d1);
        System.out.println(d2);

        StringBuilder s1 = new StringBuilder();
        for (Integer v : d1) {
            s1.append(v);
        }

        StringBuilder s2 = new StringBuilder();
        for (Integer v : d2) {
            s2.append(v);
        }

        System.out.println(s1);
        System.out.println(s2);

        int a1 = Integer.parseInt(String.valueOf(s1));
        int a2 = Integer.parseInt(String.valueOf(s2));

        System.out.println(a1 + a2);



        return null;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();
        solution.addTwoNumbers(l1, l2);
    }

}
