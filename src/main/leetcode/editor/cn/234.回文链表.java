/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // count size
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        // split as two sublist. e.g: [1, 2, 3], [1 2 3 4]
        int mid = size / 2;
        p = head;
        for (int i = 2; i <= mid; i++) {
            p = p.next;
        }
        ListNode newHead;
        if (size % 2 == 0) {
            newHead = p.next;
            p.next = null;
        } else {
            newHead = p.next.next;
            p.next = null;
        }

        // reverse one sublist
        ListNode prev = null;
        ListNode curr = newHead;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        newHead = prev;

        // compare them two
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
// @lc code=end

