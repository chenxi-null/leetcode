package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
#[WA] low level error

Counting like this:
    `while (lvlNodeCnt-- > 0)`
Change the value of this variable !!!

 */
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/*
         startNode -> x -> x
nextStartNode -> x -> x

*     *
*   * *  *

nextHead nextTail
 */
class PopulateNextRightPointer {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        while (true) {
            if (head.left == null) {
                return root;
            }

            Node tail = head;
            Node nextHead = null;
            Node nextTail = null;
            while (tail != null) {
                if (nextHead == null) {
                    nextHead = tail.left;
                    nextHead.next = tail.right;
                } else {
                    nextTail.next = tail.left;
                    nextTail.next.next = tail.right;
                }
                nextTail = tail.right;

                tail = tail.next;
            }

            head = nextHead;
        }
    }

    // #[better]: use queue's size to replace helper variable `lvlNodeCnt`
    // with extra space like queue or list
    public Node _connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int lvlNodeCnt = 1;
        while (!q.isEmpty()) {
            List<Node> currLvlNodes = new ArrayList<>();
            for (int i = 0; i < lvlNodeCnt; i++) {
                currLvlNodes.add(q.poll());
            }
            for (int i = 0; i < currLvlNodes.size(); i++) {
                Node curr = currLvlNodes.get(i);
                if (curr == null) {
                    return root;
                }
                // connect nodes of current level
                if (i + 1 < currLvlNodes.size()) {
                    curr.next = currLvlNodes.get(i + 1);
                }
                // pop nodes of next level into queue
                q.offer(curr.left);
                q.offer(curr.right);
            }
            lvlNodeCnt *= 2;
        }
        return root;
    }
}
