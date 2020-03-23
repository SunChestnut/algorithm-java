package com.sun.algorithm.solution;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/01 - 10:48
 */
public class MyStack {

    LinkedList<Integer> queue;

    @Override
    public String toString() {
        return "MyStack{" +
                "queue=" + queue +
                '}';
    }

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.addFirst(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.pop();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.getFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);

        System.out.println(obj.toString());
        System.out.println(obj.top());
        System.out.println(obj.pop());
    }
}
