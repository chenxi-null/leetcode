package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class BinaryTree_ZigzagLevelOrder {
    /*
--->            1
<---         2     3
--->       4  5   6  7
<---      8 9      10 11

    1 | 3, 2 | 4, 5, 6, 7 | 9, 8

    order:
        curr is backward, iterate curr list, first right child then left's.
            reversely iterate tmpList to offer element into queue
        e.g: 3, 2
        7,6, 5,4

        curr is forward, iterate curr list, first left's then right's.
            reversely iterate tmpList to offer element into queue
        e.g: 4,5,6,7
        8,9,10,11

    --

    q   |  tmp
    1   | [2, 3]
    3,2 | [7,6,5,4]
    4,5,6,7 | [8,9,10,11]
    11,10,9,8

    pop  : a * node  add value into res
    offer: b * node
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isForward = true;
        Stack<TreeNode> stack = new Stack<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new LinkedList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                values.add(curr.val);

                if (isForward) {
                    if (curr.left != null) {
                        stack.push(curr.left);
                    }
                    if (curr.right != null) {
                        stack.push(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        stack.push(curr.right);
                    }
                    if (curr.left != null) {
                        stack.push(curr.left);
                    }
                }
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }

            isForward = !isForward;
            res.add(values);
        }
        return res;
    }
}