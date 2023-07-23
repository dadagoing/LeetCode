package com.lxd.app.剑指offer.搜索与回溯算法.二叉搜索树与双向链表_36;

import com.lxd.app.剑指offer.搜索与回溯算法.Node;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {

    Node list;
    Node cur;


    public Node treeToDoublyList(Node root) {
        inorderTraversal(root);
        list.left = cur;
        cur.right = list;
        return root;
    }

    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (list == null) {
            list = root;
        } else {
            cur.right = root;
            root.left = cur;
        }
        cur = root;
        inorderTraversal(root.right);
    }
}