package com.lxd.app.剑指offer.搜索与回溯算法.序列化二叉树_37;

import com.lxd.app.剑指offer.搜索与回溯算法.TreeNode;

import java.util.ArrayList;
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
public class Codec {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = codec.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(codec.serialize(treeNode));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                builder.append("null,");
            } else {
                builder.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.append("]").toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if ("".equals(data)) {
            return null;
        }
        String[] strings = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
        if ("null".equals(strings[index])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        queue.add(root);
        int length = strings.length;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (index == length) {
                break;
            }
            if (!"null".equals(strings[index])) {
                TreeNode nodeLeft = new TreeNode(Integer.parseInt(strings[index++]));
                poll.left = nodeLeft;
                queue.add(nodeLeft);
            } else {
                index++;
            }
            if (index == length) {
                break;
            }
            if (!"null".equals(strings[index])) {
                TreeNode nodeRight = new TreeNode(Integer.parseInt(strings[index++]));
                poll.right = nodeRight;
                queue.add(nodeRight);
            } else {
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));