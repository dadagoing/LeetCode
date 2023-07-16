package com.lxd.app.剑指offer.链表.反转链表;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode node = null;
        while (cur != null){
            ListNode newNode = new ListNode(cur.val);
            newNode.next = node;
            node = newNode;
            cur = cur.next;
        }
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}