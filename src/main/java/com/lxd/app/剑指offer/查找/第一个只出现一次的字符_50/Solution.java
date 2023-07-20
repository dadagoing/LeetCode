package com.lxd.app.剑指offer.查找.第一个只出现一次的字符_50;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            hashMap.computeIfPresent(c, (x, y) -> -1);
            hashMap.putIfAbsent(c, i);
        }
        int index = Integer.MAX_VALUE;
        char min = ' ';
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == -1) {
                continue;
            }
            if (index > entry.getValue()) {
                index = entry.getValue();
                min = entry.getKey();
            }
        }
        return min;
    }
}