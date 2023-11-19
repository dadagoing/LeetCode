package com.lxd.app.剑指offer.分治.打印从1到最大的n位数_17;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(3)));
    }
    public int[] printNumbers(int n) {
        int size = (int) (Math.pow(10, n) - 1);
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }
}