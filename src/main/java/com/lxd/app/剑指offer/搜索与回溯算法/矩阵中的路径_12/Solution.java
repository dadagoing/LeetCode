package com.lxd.app.剑指offer.搜索与回溯算法.矩阵中的路径_12;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(solution.exist(chars, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        char c = charArray[0];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                //遍历寻找单次头
                if (board[x][y] == c) {
                    int index = 0;
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(getSetValue(x, y));
                    if (check(x, y, charArray, board, index + 1, hashSet)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean check(int x, int y, char[] charArray, char[][] board, int index, HashSet<Integer> set) {
        int length = charArray.length;
        int X = x, Y = y;
        boolean check1 = false, check2 = false, check3 = false, check4 = false;
        if (index < length) {
            char ch = charArray[index];
            index = index + 1;
            if (X + 1 < board.length && board[X + 1][Y] == ch && !set.contains(getSetValue(X + 1, Y))) {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.addAll(set);
                hashSet.add(getSetValue(X + 1, Y));
                check1 = check(X + 1, Y, charArray, board, index, hashSet);
            }
            if (X - 1 >= 0 && board[X - 1][Y] == ch && !set.contains(getSetValue(X - 1, Y))) {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.addAll(set);
                hashSet.add(getSetValue(X - 1, Y));
                check2 = check(X - 1, Y, charArray, board, index, hashSet);
            }
            if (Y + 1 < board[X].length && board[X][Y + 1] == ch && !set.contains(getSetValue(X, Y + 1))) {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.addAll(set);
                hashSet.add(getSetValue(X, Y + 1));
                check3 = check(X, Y + 1, charArray, board, index, hashSet);
            }
            if (Y - 1 >= 0 && board[X][Y - 1] == ch && !set.contains(getSetValue(X, Y - 1))) {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.addAll(set);
                hashSet.add(getSetValue(X, Y - 1));
                check4 = check(X, Y - 1, charArray, board, index, hashSet);
            }
        } else {
            return true;
        }
        return check1 || check2 || check3 || check4;
    }

    private int getSetValue(int x, int y) {
        return (x + 1) * 10 + y;
    }
}