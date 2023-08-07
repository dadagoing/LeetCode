package com.lxd.app.剑指offer.分治.数值的整数次方_16;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0000, 10));
    }

    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            return 1 / myPow(x, -power);
        }
        return myPow(x, power);
    }

    private double myPow(double x, long n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        if ((n & 1) == 0) {
            return myPow(myPow(x, n >> 1), 2);
        } else {
            return myPow(myPow(x, (n - 1) >> 1), 2) * x;
        }
    }
}