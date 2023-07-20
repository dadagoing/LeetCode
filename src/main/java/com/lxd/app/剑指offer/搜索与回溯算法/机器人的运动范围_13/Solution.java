package com.lxd.app.剑指offer.搜索与回溯算法.机器人的运动范围_13;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] arr = new boolean[m][n];
        int[] count = {0};
        checkCoving(m, n, 0, 0, k, count, arr);
        return count[0];
    }

    void checkCoving(int m, int n, int x, int y, int k, int[] count, boolean[][] arr) {
        if (x >= 0 && x < m && y >= 0 && y < n && !arr[x][y] && check(x, y, k)) {
            arr[x][y] = true;
            count[0] = count[0] + 1;
            checkCoving(m, n, x + 1, y, k, count, arr);
//            checkCoving(m, n, x - 1, y, k, count, arr);
            checkCoving(m, n, x, y + 1, k, count, arr);
//            checkCoving(m, n, x, y - 1, k, count, arr);
        }
    }

    boolean check(int x, int y, int k) {
        int sum = x % 10 + x / 10 % 10 + x / 100 % 10 + y % 10 + y / 10 % 10 + y / 100 % 10;
        if (sum > k) {
            return false;
        }
        return true;
    }
}