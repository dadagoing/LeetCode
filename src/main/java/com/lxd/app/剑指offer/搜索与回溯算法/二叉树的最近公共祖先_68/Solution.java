package com.lxd.app.剑指offer.搜索与回溯算法.二叉树的最近公共祖先_68;

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

    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return node;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            if (left || right) {
                node = root;
            }
            return true;
        }
        if (right && left) {
            node = root;
        }
        return left || right;
    }
}