package com.lxd.app.剑指offer.搜索与回溯算法.从上到下打印二叉树_Ⅰ_32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //遍历该层
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}