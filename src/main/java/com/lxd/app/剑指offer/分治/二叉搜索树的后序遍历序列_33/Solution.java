package com.lxd.app.剑指offer.分治.二叉搜索树的后序遍历序列_33;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }
        int root = postorder[postorder.length - 1], ptr = -1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            if (ptr != -1 && postorder[i] >= root) {
                return false;
            }
            if (ptr == -1 && postorder[i] < root) {
                ptr = i;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, ptr + 1))
                && verifyPostorder(Arrays.copyOfRange(postorder, ptr + 1, postorder.length - 1));
    }
}