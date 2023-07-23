package com.lxd.app.剑指offer.搜索与回溯算法.对称的二叉树_28;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node44 = new TreeNode(4);
        node1.left = node2;
        node1.right = node22;
        node2.left = node3;
        node2.right = node4;
        node22.left = node44;
        node22.right = node33;

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric1(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkNode(root.left, root.right);
    }

    private boolean checkNode(TreeNode L,TreeNode R){
        if (L == null && R == null) {
            return true;
        } else if (L != null && R != null && (L.val == R.val)) {
            return checkNode(L.left, R.right) && checkNode(L.right, R.left);
        } else {
            return false;
        }
    }

    /**
     * 思路 双端队列保存层序遍历树信息，每一层判断一次
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();
        queue1.offer(root);
        int level = 0;
        int index = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (level > index) {
                while (!deque.isEmpty()) {
                    if (deque.size() % 2 == 1) {
                        return false;
                    }
                    if (deque.peekFirst() == null && deque.peekLast() == null) {
                        deque.pollFirst();
                        deque.pollLast();
                    } else if (deque.peekFirst() != null && deque.peekLast() != null && (deque.peekFirst().val == deque.peekLast().val)) {
                        deque.pollFirst();
                        deque.pollLast();
                    } else {
                        return false;
                    }
                }
                index++;
            } else if (level == index) {
                if (queue1.isEmpty()) {
                    while (!queue2.isEmpty()) {
                        TreeNode treeNode = queue2.poll();
                        queue1.offer(treeNode.left);
                        queue1.offer(treeNode.right);
                        deque.offer(treeNode.left);
                        deque.offer(treeNode.right);
                    }
                } else {
                    while (!queue1.isEmpty()) {
                        TreeNode treeNode = queue1.poll();
                        queue2.offer(treeNode.left);
                        queue2.offer(treeNode.right);
                        deque.offer(treeNode.left);
                        deque.offer(treeNode.right);
                    }
                }
                level++;
            }
        }
        return true;
    }
}