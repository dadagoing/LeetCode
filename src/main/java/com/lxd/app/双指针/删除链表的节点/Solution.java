package com.lxd.app.双指针.删除链表的节点;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode last = cur;
        if (cur.val == val) {
            return cur.next;
        }

        while (cur != null){
            if (cur.val == val) {
                last.next = cur.next;
                break;
            }
            last = cur;
            cur = cur.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}