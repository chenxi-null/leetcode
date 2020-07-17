package com.leetcode.tree;
/*
https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

import com.leetcode.TreeNode;


/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/5
 */
public class ValidateBinarySearchTree {

    private long last = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isValidBST(root.left)
                && last < root.val) {
            last = root.val;
            return isValidBST(root.right);
        }
        return false;
    }
}
