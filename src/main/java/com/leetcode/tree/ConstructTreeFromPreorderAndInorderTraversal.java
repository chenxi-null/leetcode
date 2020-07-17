package com.leetcode.tree;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

---

10:53
 */

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIdxMap.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, preorder);
    }

    private int rootIdx = 0;
    private Map<Integer, Integer> valToIdxMap = new HashMap<>();

    private TreeNode dfs(int inStartIdx, int inEndIdx, int[] preorder) {
        if (inStartIdx > inEndIdx) {
            return null;
        }

        int val = preorder[rootIdx];
        TreeNode root = new TreeNode(val);
        Integer idx = valToIdxMap.get(val);

        ++rootIdx;

        root.left = dfs(inStartIdx, idx - 1, preorder);
        root.right = dfs(idx + 1, inEndIdx, preorder);
        return root;
    }
}