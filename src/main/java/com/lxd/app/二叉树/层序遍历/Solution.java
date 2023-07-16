package com.lxd.app.二叉树.层序遍历;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        if (list.size() <= level) {
            list.add(integers);
        } else {
            list.get(level).addAll(integers);
        }
        level++;
        levelOrderDG(level, list, root.left);
        levelOrderDG(level, list, root.right);
        return list;
    }

}