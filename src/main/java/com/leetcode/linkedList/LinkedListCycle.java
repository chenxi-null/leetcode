package com.leetcode.linkedList;
/*
141. Linked List Cycle
 */

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    /*
         x -> x -> x -> x -> x
                   ^         |
                   |_________|

    ---
    a, b

    slow:  x == a + n * b + o
    quick: y == 2x == a + m * b + o

    2 (a + n * b + o) == a + m * b + o
    a + o + 2 * n * b == m * b
    a + o = (m - 2 * n) * b

    a + o = N * b

        slow
    |----|----|
       o   a

    cases:
    h -> NULL
    h -> x -> NULL
    */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;

            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}