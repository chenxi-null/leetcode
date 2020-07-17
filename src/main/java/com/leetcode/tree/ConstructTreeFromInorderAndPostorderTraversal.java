package com.leetcode.tree;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-e-5/
 */

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIdxMap.put(inorder[i], i);
        }
        this.postorder = postorder;
        this.rootIdx = postorder.length - 1;
        return dfs(0, inorder.length - 1);
    }

    private int[] postorder;
    private int rootIdx;
    private Map<Integer, Integer> valToIdxMap = new HashMap<>();

    private TreeNode dfs(int inStartIdx, int inEndIdx) {
        if (inEndIdx < inStartIdx) {
            return null;
        }

        int val = postorder[rootIdx];
        --rootIdx;

        TreeNode root = new TreeNode(val);
        int idx = valToIdxMap.get(val);
        root.right = dfs(idx + 1, inEndIdx);
        root.left = dfs(inStartIdx, idx - 1);
        return root;
    }
}