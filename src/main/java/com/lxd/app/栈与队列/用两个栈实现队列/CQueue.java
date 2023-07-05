package com.lxd.app.栈与队列.用两个栈实现队列;

import java.util.Stack;

class CQueue {

    public static void main(String[] args) {
        int value = 0;
        CQueue obj = new CQueue();
        obj.appendTail(value);
        int param_2 = obj.deleteHead();
    }

    private Stack<Integer> stackHead;
    private Stack<Integer> stackTail;

    public CQueue() {
        stackTail = new Stack<>();
        stackHead = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stackHead.empty()) {
            stackTail.push(stackHead.pop());
        }
        stackTail.push(value);
    }

    public int deleteHead() {
        while (!stackTail.empty()) {
            stackHead.push(stackTail.pop());
        }
        if (stackHead.empty()) {
            return -1;
        }
        return stackHead.pop();
    }
}