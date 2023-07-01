package com.lxd.app.剑指offer.链表.复杂链表的复制;


import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Node node0 = new Node(3);
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        node0.next = node1;
        node1.next = node2;
        node1.random = node0;
        Solution solution = new Solution();
        solution.copyRandomList(node0);
    }

    private static HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node result = null;
        Node cur = null;
        Node node = head;
        if (node == null) {
            return node;
        }
        while (node != null) {
            Node newNode;
            //节点放入缓存
            if (map.containsKey(node)) {
                newNode = map.get(node);
            } else {
                newNode = new Node(node.val);
                map.put(node, newNode);
            }

            //处理next逻辑
            if (result == null) {
                result = newNode;
            } else {
                cur.next = newNode;
            }
            cur = newNode;

            //处理random逻辑
            if (node.random != null) {
                if (map.containsKey(node.random)) {
                    newNode.random = map.get(node.random);
                } else {
                    newNode.random = new Node(node.random.val);
                    map.put(node.random, newNode.random);
                }
            }

            node = node.next;
        }
        return result;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}