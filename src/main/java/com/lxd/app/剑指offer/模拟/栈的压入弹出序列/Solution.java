package com.lxd.app.剑指offer.模拟.栈的压入弹出序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(new int[]{0, 1}, new int[]{0, 1}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length != pushed.length) {
            return false;
        }
        HashSet<Integer> hashSet = Arrays.stream(pushed).boxed().collect(Collectors.toCollection(HashSet::new));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, poppedLength = popped.length; i < poppedLength; i++) {
            int pop = popped[i];
            if (!hashSet.contains(pop)) {
                return false;
            }
            if (i == 0 && stack.isEmpty()) {
                for (int push : pushed) {
                    if (push == pop) {
                        break;
                    }
                    stack.push(push);
                }
            }
            if (stack.peek() == pop) {
                stack.pop();
            } else {
                if (popped[i] != pushed[i]) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}