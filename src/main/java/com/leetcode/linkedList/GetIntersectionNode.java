package com.leetcode.linkedList;
/*
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

---

A: x -> x -> x
B: x -> x -> x

A: x -> x -> x
B: x -> x -> x
 */

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class GetIntersectionNode {

    // #[Better]
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        boolean p1Switched = false;
        boolean p2Switched = false;
        while (true) {
            if (p1 == null) {
                if (p1Switched) {
                    return null;
                } else {
                    p1Switched = true;
                    p1 = headB;
                }
            }
            if (p2 == null) {
                if (p2Switched) {
                    return null;
                } else {
                    p2Switched = true;
                    p2 = headA;
                }
            }

            if (p1 == p2) {
                return p1;
            }

            p1 = p1.next;
            p2 = p2.next;
        }
    }

    public ListNode _getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // find tail of listA
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }

        // try to create a cyclic list whose entry node is headA
        tail.next = headB;

        // circle detection
        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        boolean notCyclic = !(fast != null && fast.next != null);
        if (notCyclic) {
            // restore listA
            tail.next = null;
            return null;
        }

        // find the entry node of circle
        ListNode finder = headA;
        while (finder != slow) {
            finder = finder.next;
            slow = slow.next;
        }
        // restore listA
        tail.next = null;
        return finder;
    }
}