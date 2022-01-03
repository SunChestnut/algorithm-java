package com.sun.offer.simple;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunyl
 * @date 2022/1/1 11:09 下午
 * @see com.sun.offer.simple
 */
public class Offer30 {

    class MinStack {

        private Deque<Integer> stackA;
        private Deque<Integer> stackB;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackA = new ArrayDeque<>();
            stackB = new ArrayDeque<>();
        }

        public void push(int x) {
            stackA.push(x);
            if (stackB.isEmpty() || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            Integer popValue = stackA.pop();
            if (popValue.equals(stackB.peek())) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }

}
