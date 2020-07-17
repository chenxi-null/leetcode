package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreelevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<>();
        List<List<TreeNode>> nodesList = new LinkedList<>();

        nodesList.add(Collections.singletonList(root));

        while (true) {
            List<TreeNode> lastLevelNodes = nodesList.get(nodesList.size() - 1);
            if (lastLevelNodes.isEmpty()) {
                break;
            }

            List<Integer> lastLevelValues = lastLevelNodes.stream()
                    .map(node -> node.val).collect(Collectors.toList());
            res.add(lastLevelValues);

            List<TreeNode> newLastLevelNodes = new LinkedList<>();
            for (TreeNode node : lastLevelNodes) {
                if (node.left != null) {
                    newLastLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    newLastLevelNodes.add(node.right);
                }
            }
            nodesList.add(newLastLevelNodes);
        }
        return res;
    }
}