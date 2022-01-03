package com.sun.offer.simple;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunyl
 * @date 2022/1/1 6:51 下午
 * @see com.sun.offer.simple
 */
public class Offer09 {

    static class CQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    Integer pop = stack1.pop();
                    stack2.push(pop);
                }
            }
            return stack2.pop();
        }
    }

}
