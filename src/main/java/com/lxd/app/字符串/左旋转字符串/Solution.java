package com.lxd.app.字符串.左旋转字符串;

class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                result[chars.length - n + i] = chars[i];
            } else {
                result[i - n] = chars[i];
            }
        }
        return new String(result);
    }
}