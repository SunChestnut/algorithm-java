package com.sun.solution.simple;

/**
 * leetcode234. 回文链表
 *
 * @author syl
 * @date 2020/04/14 - 09:06
 */
public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        // 计算链表长度
        int n = 0;
        ListNode cur1 = head;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }

        // 使用数组存储链表元素
        int[] arr = new int[n];
        ListNode cur2 = head;
        int i = 0;
        while (cur2 != null) {
            arr[i] = cur2.val;
            i++;
            cur2 = cur2.next;
        }

        // 采用双指针法判断数组内元素是否是回文
        int r = n - 1;
        for (int l = 0; l < n / 2; l++) {
            if (arr[l] == arr[r]) {
                r--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(1);
        head.next = next1;
//        next1.next = next2;
//        next2.next = next3;

        PalindromeLinkedList solution = new PalindromeLinkedList();
//        System.out.println(solution.isPalindrome(head));

        System.out.println(solution.isPalindrome(null));
    }

}
