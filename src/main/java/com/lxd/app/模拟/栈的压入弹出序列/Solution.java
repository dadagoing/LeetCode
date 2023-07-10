package com.lxd.app.模拟.栈的压入弹出序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length != pushed.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (true){
                if (stack.empty() || stack.peek() != popped[index]) {
                    break;
                }
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}