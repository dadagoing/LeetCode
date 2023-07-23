package com.lxd.app.剑指offer.搜索与回溯算法.二叉树的深度_Ⅰ_55;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int deep = 0;
        return dfs(root, deep);
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        deep = deep + 1;
        return Math.max(dfs(root.left, deep), dfs(root.right, deep));
    }
}