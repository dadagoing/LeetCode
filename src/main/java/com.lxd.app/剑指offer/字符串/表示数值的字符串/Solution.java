package org.example.剑指offer.字符串.表示数值的字符串;

class Solution {
    public boolean isNumber(String s) {
        boolean isNum = false;
        boolean isZ = false;
        boolean isF = false;
        boolean isE = false;
        boolean isXS = false;
        boolean isBank = false;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (isNum || isZ || isF || isE || isXS) {
                    isBank = true;
                }
            } else if (c == '+') {
                if (isBank || isNum || isZ) {
                    return false;
                }
                isZ = true;
            } else if (c == '-') {
                if (isBank || isNum || isF) {
                    return false;
                }
                isF = true;
            } else if (c <= '9' && c >= '0') {
                if (isBank) {
                    return false;
                }
                isNum = true;
            } else if (c == 'e' || c == 'E') {
                if (isBank || !isNum || isE) {
                    return false;
                }
                isE = true;
                isNum = false;
                isZ = false;
                isF = false;
            } else if (c == '.') {
                if (isBank || isE || isXS) {
                    return false;
                }
                isXS = true;
                isZ = true;
                isF = true;
            } else {
                return false;
            }

        }
        return isNum;
    }

}