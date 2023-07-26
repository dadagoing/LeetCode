package com.lxd.app.剑指offer.搜索与回溯算法.平衡二叉树_Ⅱ_55;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.LinkedList;

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
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1, 8};
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(1);
        queue.add(root);
        int length = ints.length;
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (index == length) {
                break;
            }
            if (ints[index] != -1) {
                TreeNode nodeLeft = new TreeNode(ints[index++]);
                poll.left = nodeLeft;
                queue.add(nodeLeft);
            } else {
                index++;
            }
            if (index == length) {
                break;
            }
            if (ints[index] != -1) {
                TreeNode nodeRight = new TreeNode(ints[index++]);
                poll.right = nodeRight;
                queue.add(nodeRight);
            } else {
                index++;
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, 0) != -1;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        deep = deep + 1;
        int left = dfs(root.left, deep);
        int right = dfs(root.right, deep);
        return Math.abs(left - right) > 1 || left == -1 || right == -1 ? -1 : Math.max(left, right);
    }
}