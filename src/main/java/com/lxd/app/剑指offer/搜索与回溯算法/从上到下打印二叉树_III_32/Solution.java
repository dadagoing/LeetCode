package com.lxd.app.剑指offer.搜索与回溯算法.从上到下打印二叉树_III_32;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int level = 0;
        return levelOrderDG(level, list, root);
    }

    private List<List<Integer>> levelOrderDG(int level, List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return list;
        }
        //遍历该层
        if (list.size() <= level) {
            LinkedList<Integer> integers = new LinkedList<>();
            integers.add(root.val);
            list.add(integers);
        } else {
            if (level % 2 == 0) {
                ((LinkedList)list.get(level)).offerLast(root.val);
            } else {
                ((LinkedList)list.get(level)).offerFirst(root.val);
            }
        }
        level++;
        levelOrderDG(level, list, root.left);
        levelOrderDG(level, list, root.right);
        return list;
    }
}