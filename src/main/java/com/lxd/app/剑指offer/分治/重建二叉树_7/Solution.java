package com.lxd.app.剑指offer.分治.重建二叉树_7;

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

    TreeNode root;

    TreeNode cur;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return root;
        }
        TreeNode node = new TreeNode(preorder[0]);
        if (root == null) {
            root = node;
        } else {

        }
        return root;
    }
}