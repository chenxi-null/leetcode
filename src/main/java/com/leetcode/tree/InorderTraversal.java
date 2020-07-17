package com.leetcode.tree;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import com.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class InorderTraversal {

    /*
public class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
     */


    // ---------------------- iteratively ----------------------

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
    }

    /*
    stack
    push
        right-child
        root
        left-child

    lc
    root
    rc
     */
    public List<Integer> _inorderTraversal_05_14(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();

            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;
            if (leftChild == null && rightChild == null) {
                output.add(node.val);
            } else {
                if (rightChild != null) {
                    deque.offerLast(rightChild);
                }

                node.left = null;
                node.right = null;
                deque.offerLast(node);

                if (leftChild != null) {
                    deque.offerLast(leftChild);
                }
            }
        }
        return output;
    }

    // ---------------------- recursive variant ----------------------

    public List<Integer> _inorderTraversal(TreeNode root) {
        help(root);
        return output;
    }

    private List<Integer> output = new LinkedList<>();

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }

        help(root.left);
        output.add(root.val);
        help(root.right);
    }
}