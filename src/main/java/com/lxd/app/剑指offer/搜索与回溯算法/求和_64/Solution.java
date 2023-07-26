package com.lxd.app.剑指offer.搜索与回溯算法.求和_64;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(3));
    }

    public int sumNums(int n) {
        boolean b = n != 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}