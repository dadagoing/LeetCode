package com.lxd.app.双指针.两个链表的第一个公共节点;

import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        /*[4,1,8,4,5] [5,0,1,8,4,5]*/
        ListNode listNode0 = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(8);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNodeB0 = new ListNode(5);
        ListNode listNodeB1 = new ListNode(0);
        ListNode listNodeB2 = new ListNode(1);
        ListNode listNodeB3 = new ListNode(8);
        ListNode listNodeB4 = new ListNode(4);
        ListNode listNodeB5 = new ListNode(5);
        listNodeB0.next = listNodeB1;
        listNodeB1.next = listNodeB2;
        listNodeB2.next = listNodeB3;
        listNodeB3.next = listNodeB4;
        listNodeB4.next = listNodeB5;

        Solution solution = new Solution();
        solution.getIntersectionNode(listNode0, listNodeB0);
    }

    /**
     * 双指针 解法
     * 最浪漫的解法
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        if (headA == null || headB == null) {
            return null;
        }

        //需要考虑没有相交情况，死循环
//        while (curB != curA){
//            curA = curA.next == null ? headA : curA.next;
//            curB = curB.next == null ? headB : curB.next;
//        }

        //无相交情况走了 m+n最后为空结束
        while (curB != curA){
            curA = curA == null ? headA : curA.next;
            curB = curB == null ? headB : curB.next;
        }
        return curB;
    }



    /**
     * 哈希解法
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        HashSet<ListNode> nodeHashMap = new HashSet<>();
        while (curA != null) {
            nodeHashMap.add(curA);
            curA = curA.next;
        }

        while (curB != null) {
            if (nodeHashMap.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}