package com.lxd.app.剑指offer.搜索与回溯算法.平衡二叉树_Ⅱ_55;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.LinkedList;

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
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1, 8};
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(1);
        queue.add(root);
//        while ()
        for (int anInt : ints) {

            TreeNode node = new TreeNode(anInt);
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(dfs(root.left, 0) - dfs(root.right, 0)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.left);
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        deep = deep + 1;
        return Math.max(dfs(root.left, deep), dfs(root.right, deep));
    }
}