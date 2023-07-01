package org.example.剑指offer.字符串.替换空格;

class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 3];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result[index++] = '%';
                result[index++] = '2';
                result[index++] = '0';
            } else {
                result[index++] = chars[i];
            }
        }
        return new String(result, 0, index);
    }
}