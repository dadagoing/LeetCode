package com.lxd.app.栈与队列.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class MaxQueue {


    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        pushItem(maxQueue, value);
    }

    private void pushItem(Deque<Integer> deque, int nums) {
        if (deque.isEmpty()) {
            deque.offer(nums);
        } else if (deque.peekLast() < nums) {
            deque.removeLast();
            pushItem(deque, nums);
        } else {
            deque.offer(nums);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer polled = queue.poll();
        if (Objects.equals(maxQueue.peekFirst(), polled)) {
            maxQueue.removeFirst();
        }
        return polled;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */