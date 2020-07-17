package com.leetcode.tree;
/*
https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/6
 */
public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        dfs(root);
        updateModes();

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int maxCnt = -1;
    private int cnt = 0;
    private Integer prev;
    private List<Integer> list = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        int curr = root.val;
        if (prev == null) {
            cnt = 1;
        } else if (prev == curr) {
            ++cnt;
        } else {
            updateModes();
            cnt = 1;
        }
        prev = curr;

        dfs(root.right);
    }

    private void updateModes() {
        if (cnt > maxCnt) {
            maxCnt = cnt;
            list.clear();
            list.add(prev);
        } else if (cnt == maxCnt) {
            list.add(prev);
        }
    }
}
