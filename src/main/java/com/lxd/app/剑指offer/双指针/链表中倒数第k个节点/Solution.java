package com.lxd.app.剑指offer.双指针.链表中倒数第k个节点;

import java.util.HashMap;

class Solution {
    /**
     * 双指针方式计算，让两个指针间距k，第一个指针到尾部，则第二个指针为结果
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        int key = 1;
        while (first != null){
            if (key == k) {
                last = last.next;
            } else {
                key++;
            }
            first = first.next;
        }
        return last;
    }

    /**
     * 先算出链表长度，再算倒数
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();
        ListNode node = head;
        int key = 1;
        while (node != null){
            nodeHashMap.put(key++, node);
            node = node.next;
        }
        return nodeHashMap.get(nodeHashMap.size() - k + 1);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}