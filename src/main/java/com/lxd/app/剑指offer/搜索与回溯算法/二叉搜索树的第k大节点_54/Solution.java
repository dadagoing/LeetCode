package com.lxd.app.剑指offer.搜索与回溯算法.二叉搜索树的第k大节点_54;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int kthLargest(TreeNode root, int k) {
        int[] ints = {k, 0};
        dfs(root, k);
        return ints[1];
    }

    private void dfs(TreeNode root, int k) {
        if (root != null) {
            dfs(root.right, k);
            k = k - 1;
            if (k == 0) {
                max = root.val;
                return;
            }
            dfs(root.left, k);
        }
    }
}