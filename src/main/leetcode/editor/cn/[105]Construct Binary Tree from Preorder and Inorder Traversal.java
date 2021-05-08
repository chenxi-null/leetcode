//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 1025 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        int rootVal = preorder[s1];
        int k = s2;
        while (inorder[k] != rootVal) {
            k++;
        }
        int leftSubLen = k - s2;

        TreeNode root = new TreeNode(rootVal);
        root.left = help(preorder, s1 + 1, s1 + leftSubLen, inorder, s2, k - 1);
        root.right = help(preorder, s1 + leftSubLen + 1, e1, inorder, k + 1, e2);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*

preinorder: root -> left -> right

                      k
inorder:    left -> root -> right
 */
