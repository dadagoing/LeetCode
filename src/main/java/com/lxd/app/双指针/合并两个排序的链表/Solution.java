package com.lxd.app.双指针.合并两个排序的链表;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * 用递归的思路，每次递归返回要拆分出的节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 初始想法 显得很丑陋，区分情况去循环判断
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode node = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (true) {
            if (cur1 != null && cur2 != null && cur2.val > cur1.val) {
                if (head == null) {
                    head = cur1;
                } else {
                    node.next = cur1;
                }
                node = cur1;
                cur1 = cur1.next;
            } else if (cur1 != null && cur2 != null) {
                if (head == null) {
                    head = cur2;
                } else {
                    node.next = cur2;
                }
                node = cur2;
                cur2 = cur2.next;
            } else {
                if (cur1 == null) {
                    node.next = cur2;
                } else {
                    node.next = cur1;
                }
                break;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}