package com.sun.solution.simple;

import java.util.Arrays;

/**
 * TODO
 *
 * @author syl
 * @date 2020/04/13 - 09:07
 */
public class ReverseLinkedList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);

        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;

        //防止链表循环，需要将head.next设置为空
        head.next = null;

        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        for (int value : arr) {
            curNode = curNode.next;
            curNode.val = value;
        }


        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode cur2 = solution.reverseList(head);
        while (cur2 != null) {
            System.out.println(cur2.val + "->");
            cur2 = cur2.next;
        }
    }
}
