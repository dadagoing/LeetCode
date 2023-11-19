package com.lxd.app.剑指offer.搜索与回溯算法.字符串的排列_38;

import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }

    public String[] permutation(String s) {
        if ("".equals(s)) {
            return new String[]{};
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        HashSet<String> strings = permutation(chars);
        return strings.toArray(new String[0]);
    }

    public HashSet<String> permutation(char[] chars) {
        HashSet<String> strings = new HashSet<>();
        if (chars.length == 0) {
            return strings;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(String.valueOf(chars[i]))) {
                continue;
            }
            set.add(String.valueOf(chars[i]));
            HashSet<String> hashSet = permutation(swap(i, chars));
            if (hashSet.isEmpty()) {
                strings.add(String.valueOf(chars[i]));
            } else {
                for (String s : hashSet) {
                    strings.add(chars[i] + s);
                }
            }
        }
        return strings;
    }

    char[] swap(int index, char[] chars){
        char tmp = chars[0];
        chars[0] = chars[index];
        chars[index] = tmp;
        char[] copy = Arrays.copyOfRange(chars, 1, chars.length);
        tmp = chars[index];
        chars[index] = chars[0];
        chars[0] = tmp;
        return copy;
    }

}