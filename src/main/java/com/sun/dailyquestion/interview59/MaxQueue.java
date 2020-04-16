package com.sun.dailyquestion.interview59;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/07 - 15:41
 */
public class MaxQueue {

    private int[] array;

    private int front;

    private int rear;

    public MaxQueue() {
        array = new int[2000];
    }

    public int max_value() {
        if (array.length == 0) {
            return -1;
        }
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }

        return maxValue;
    }

    public void push_back(int value) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;
    }

    public int pop_front() {
        if (array.length == 0) {
            return -1;
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public static void main(String[] args) throws Exception {
        MaxQueue obj = new MaxQueue();
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}
