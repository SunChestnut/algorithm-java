package com.sun.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sunyl
 * @date 2022/1/16 5:51 PM
 * @see com.sun.everyday
 */
public class LinkedListRandomNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 先计算链表的长度，根据链表的长度设置可生成随机数的最大值和最小值，生成随机数，随机数即表示返回链表的第几个元素值
    // 根据随机数大小遍历链表，找到目标值（ 😭 啰嗦）
//    private ListNode head;
//
//    public LinkedListRandomNode(ListNode head) {
//        this.head = head;
//    }
//
//    public int getRandom() {
//        int n = 0;
//        ListNode k = head;
//        while (k != null) {
//            n++;
//            k = k.next;
//        }
//        int max = n, min = 1;
//        int randomV = (int) Math.floor(Math.random() * (max - min + 1) + min);
//        System.out.println("Random Value:" + randomV);
//        k = head;
//        randomV--;
//        while (randomV > 0) {
//            k = k.next;
//            randomV--;
//        }
//        return k.val;
//    }

    private List<Integer> list;

    private Random random;

    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        LinkedListRandomNode solution = new LinkedListRandomNode(head);
        System.out.println(solution.getRandom());
    }

}
