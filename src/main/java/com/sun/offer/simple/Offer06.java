package com.sun.offer.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author sunyl
 * @date 2022/1/2 10:24 下午
 * @see com.sun.offer.simple
 */
public class Offer06 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrintWithList(ListNode head) {
        ListNode k = head;
        List<Integer> tmp = new ArrayList<>();
        while (k != null) {
            tmp.add(0, k.val);
            k = k.next;
        }
        return tmp.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] reversePrintWithStack(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode k = head;
        while (k != null) {
            deque.push(k.val);
            k = k.next;
        }
        int[] res = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            int pop = deque.pop();
            res[index++] = pop;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        printNode(head);

        Offer06 solution = new Offer06();
        System.out.println(Arrays.toString(solution.reversePrintWithStack(head)));
    }

    private static void printNode(ListNode head) {
        ListNode k = head;
        while (k != null) {
            System.out.print(k.val + " ");
            k = k.next;
        }
        System.out.println();
    }

}
