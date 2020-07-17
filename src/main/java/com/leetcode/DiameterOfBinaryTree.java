package com.leetcode;
/*

Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/11
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxLength;
    }

    int maxLength = 0;

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftDepth = maxDepth(node.left) + 1;
        int rightDepth = maxDepth(node.right) + 1;

        int tmp = leftDepth + rightDepth;
        if (tmp > maxLength) {
            maxLength = tmp;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
