package com.lxd.app.剑指offer.搜索与回溯算法.二叉树中和为某一值的路径_34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null || target - root.val < 0) {
            return list;
        }
        LinkedList<Integer> arrayList;
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                arrayList = new LinkedList<>();
                list.add(arrayList);
                arrayList.add(root.val);
                return list;
            } else {
                return list;
            }
        }
        List<List<Integer>> listLeft = pathSum(root.left, target - root.val);
        List<List<Integer>> listRight = pathSum(root.right, target - root.val);
        if (listLeft.size() > 0) {
            for (List<Integer> integerList : listLeft) {
                LinkedList linkedList = (LinkedList) integerList;
                linkedList.addFirst(root.val);
            }
            list.addAll(listLeft);
        }
        if (listRight.size() > 0) {
            for (List<Integer> integerList : listRight) {
                LinkedList linkedList = (LinkedList) integerList;
                linkedList.addFirst(root.val);
            }
            list.addAll(listRight);
        }
        return list;
    }


}