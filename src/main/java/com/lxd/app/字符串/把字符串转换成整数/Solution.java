package com.lxd.app.字符串.把字符串转换成整数;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("0-1"));
    }

    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        boolean isZFChar = false;
        boolean isZF = true;
        boolean isNum = false;
        int result = 0;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                isNum = true;
                if (result > Integer.MAX_VALUE / 10) {
                    return isZF ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (result == Integer.MAX_VALUE / 10) {
                    if (isZF) {
                        if (aChar - '0' >= Integer.MAX_VALUE % 10) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (aChar - '0' >= Integer.MIN_VALUE % 10 * -1) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + aChar - '0';
            } else {
                if ((aChar == '-' || aChar == '+') && !isZFChar && !isNum) {
                    isZFChar = true;
                    isZF = aChar == '+';
                } else if (aChar == ' ') {
                    if (isZFChar || isNum) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return isZF ? result : -1 * result;
    }
}