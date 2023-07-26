package com.lxd.app.剑指offer.搜索与回溯算法.二叉搜索树的最近公共祖先_68;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val > p.val && node.val < q.val) {
                return node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.left != null) {
                queue.add(node.right);
            }
        }
        return null;
    }
}