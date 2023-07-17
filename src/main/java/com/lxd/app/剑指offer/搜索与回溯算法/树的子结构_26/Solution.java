package com.lxd.app.剑指offer.搜索与回溯算法.树的子结构_26;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        TreeNode node3_b = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(node1, node3_b));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //遍历该层
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == B.val) {
                Boolean aBoolean = preorderTraversal(node, B);
                if (aBoolean) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    public Boolean preorderTraversal(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return preorderTraversal(A.left, B.left) && preorderTraversal(A.right, B.right);
        }
        return false;
    }
}

