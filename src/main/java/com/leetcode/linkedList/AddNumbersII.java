package com.leetcode.linkedList;

import com.leetcode.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class AddNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        Stack<Integer> s = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int v1 = s1.empty() ? 0 : s1.pop();
            int v2 = s2.empty() ? 0 : s2.pop();
            int t = (v1 + v2 + carry);
            int v = t % 10;
            carry = t / 10;
            s.push(v);
        }
        if (carry > 0) {
            s.push(1);
        }

        if (s.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(s.pop());
        ListNode prev = head;
        while (!s.isEmpty()) {
            ListNode curr = new ListNode(s.pop());
            prev.next = curr;
            prev = curr;
        }
        return head;
    }



    //----------------------------------------------------

    /*
    Stupid!
    Bro, Drawing before coding, ok?

    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7
     */
    public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
        Pair<ListNode, Integer> p = help(l1, l2);
        ListNode node = p.getLeft();
        Integer carry = p.getRight();

        if (carry > 0) {
            ListNode res = new ListNode(1);
            res.next = node;
            return res;
        } else {
            return node;
        }
    }

    private Pair<ListNode, Integer> help(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return Pair.of(null, 0);
        }

        Pair<ListNode, Integer> p = help(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        ListNode nextNode = p.getLeft();
        int carry = p.getRight();

        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        int t = (v1 + v2 + carry);
        int v = t % 10;
        carry = t / 10;

        ListNode currNode = new ListNode(v);
        currNode.next = nextNode;

        return Pair.of(currNode, carry);
    }

    private static class Pair<L, R> {
        private L l;
        private R r;

        public static <L, R> Pair<L, R> of(L l, R r) {
            return new Pair<>(l, r);
        }

        private Pair(L l, R r) {
            this.l = l;
            this.r = r;
        }

        public L getLeft() {
            return this.l;
        }

        public R getRight() {
            return this.r;
        }
    }
}