package com.lxd.app.栈与队列.包含min函数的栈;

import java.util.LinkedList;
import java.util.List;

class MinStack {

    int min = Integer.MIN_VALUE;

    List<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stack.add(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer remove = stack.remove(stack.size() - 1);
//        if (remove ) {
//        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int min() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */