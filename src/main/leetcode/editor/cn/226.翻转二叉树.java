/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode rightChild = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightChild);
        return root;
    }
}
// @lc code=end

