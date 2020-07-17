package com.leetcode.weekly.weekly190.third;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new Solution().pseudoPalindromicPaths(root));
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new boolean[10]);
        return ans;
    }

    private int ans = 0;

    private void dfs(TreeNode root, boolean[] hash) {

        hash[root.val] = !hash[root.val];

        if (root.left != null) {
            boolean[] h1 = new boolean[10];
            System.arraycopy(hash, 0, h1, 0, 10);
            dfs(root.left, h1);
        }
        if (root.right != null) {
            boolean[] h2 = new boolean[10];
            System.arraycopy(hash, 0, h2, 0, 10);
            dfs(root.right, h2);
        }
        if (root.left == null && root.right == null) {
            //System.out.println(Arrays.toString(hash));
            int size = 0;
            for (boolean b : hash) {
                if (b) {
                    size++;
                }
            }
            if (size == 0 || size == 1) {
                ans++;
            }
        }
    }
}

