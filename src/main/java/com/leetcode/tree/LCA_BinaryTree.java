package com.leetcode.tree;
/*
236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */

import com.leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LCA_BinaryTree {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }

    // find p or q
    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean foundLeft = find(root.left, p, q);
        boolean foundRight = find(root.right, p, q);

        if (root == p || root == q) {
            if (foundLeft || foundRight) {
                ans = root;
                return false;
            } else {
                return true;
            }
        }

        if (foundLeft && foundRight) {
            ans = root;
            return false;
        } else {
            return foundLeft || foundRight;
        }
    }
}