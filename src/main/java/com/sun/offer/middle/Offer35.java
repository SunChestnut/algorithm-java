package com.sun.offer.middle;

/**
 * @author sunyl
 * @date 2021/10/13 2:38 下午
 * @see com.sun.offer.middle
 */
public class Offer35 {

    public static Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        // 复制每一个节点，并将每个节点指向其副本
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        // 概念副本中每个 random 的指向
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }

        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }

        return headNew;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        /**
         * 遇到个很有意思的问题，在此记录下：
         * 如果在 Node 类中加了 toString() 方法，在构造 Node 实例时就会报错：java.lang.StackOverflowError
         * 但是如果取消 toString() 方法中打印 random 值的部分，就不会报错了……
         * 单链表中的每个节点的实例都提前创建了，也就是说，堆中已经存在时实例，但是这个结合具体的错误信息看，好像是因为无法找到 random 指向的实例。
         * 具体的报错原因有待考察 ❗️
         */
        head.random = null;
        node2.random = head;
        node3.random = node5;
        node4.random = node2;
        node5.random = head;

        Node node = copyRandomList(head);
        System.out.println(node);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "val=" + val +
//                    ", next=" + next +
//                    ", random=" + random +
//                    '}';
//        }
    }
}
