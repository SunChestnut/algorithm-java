package com.sun.offerII;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author sunyl
 * @date 2021/12/19 6:10 下午
 * @see com.sun.offerII
 */
public class Solution023 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ListNode)) {
                return false;
            }
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // ListNode 需要重写 equals 和 hashcode，如果 val 和 next 值相同，则判定两个节点相等
        // 为什么 set 中存储的是 ListNode，而不是 val 呢？
        // A 和 B 的相交节点，需要满足「节点值相同」和「该节点指向的下个节点也相同」两个条件
        Set<ListNode> setA = new HashSet<>();
        ListNode pA = headA, pB = headB;
        while (null != pA) {
            setA.add(pA);
            pA = pA.next;
        }
        while (null != pB) {
            if (setA.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution023 solution = new Solution023();
        ListNode headA = solution.packageListNode(new int[]{4, 1, 8, 4, 5});
        ListNode headB = solution.packageListNode(new int[]{5, 0, 1, 8, 4, 5});

        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(solution.printListNode(intersectionNode));

    }

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num, mid;
        long squar;
        while (left <= right) {
            mid = left + (right - left) / 2;
            squar = (long) mid * mid;
            if (squar == num) {
                return true;
            } else if (squar < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private ListNode packageListNode(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode p = head;
        for (int i = 1; i < values.length; i++) {
            p.next = new ListNode(values[i]);
            p = p.next;
        }
        p.next = null;
        return head;
    }

    private String printListNode(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            builder.append(p.val);
            p = p.next;
        }
        return builder.toString();
    }

}
