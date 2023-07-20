package com.lxd.app.二叉树.判断二叉搜索树;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        if (root.left != null ) {
            return isValidBST(root.left);
        }
        if (root.right != null ) {
            return isValidBST(root.right);
        }
        return true;
    }
}