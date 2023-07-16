package com.lxd.app.剑指offer.链表.从尾到头打印链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur.next != null){
            cur = cur.next;
            size++;
        }
        int[] arr = new int[size];
        cur = head;
        while (cur.next != null){
            cur = cur.next;
            size--;
            arr[size] = cur.val;
        }
        return arr;
    }
}