package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/8
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generate(n, 0);
    }

    private List<TreeNode> generate(int n, int offset) {
        List<TreeNode> res = new ArrayList<>();

        if (n == 0) {
            res.add(null);
            return res;
        }

        if (n == 1) {
            res.add(new TreeNode(1 + offset));
            return res;
        }

        for (int k = 1; k <= n; k++) {
            List<TreeNode> leftTrees = generate(k - 1, offset);
            List<TreeNode> rightTrees = generate(n - k, k + offset);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(k + offset);

                    if (leftTree != null) {
                        root.left = leftTree;
                    }
                    if (rightTree != null) {
                        root.right = rightTree;
                    }
                    res.add(root);
                }
            }
        }
        return res;
    }
}
