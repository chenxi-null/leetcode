package com.leetcode.linkedList;
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

https://leetcode-cn.com/problems/reverse-linked-list
 */

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
@SuppressWarnings("DuplicatedCode")
class ReverseList {

    /*
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

      prev  p    next
    1 <- 2  3 -> 4 -> 5

             prev  p
    1 <- 2 <- 3    4 -> 5

                     p
    1 <- 2 <- 3 <- 4 5


    next = p.next;
    p.next = prev
    prev = p;
    p = next;

    cases:

    null
    1
    1 2
     */
    public ListNode reverseList_20210421(ListNode h) {
        ListNode prev = null;
        ListNode p = h;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

    /*
     1 -> (k-1) -> k -> (k+1) <- ... <- n
     */
    public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /*
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    prev curr -> next

    null h -> x
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            //curr.next = (curr == head) ? null : prev;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
