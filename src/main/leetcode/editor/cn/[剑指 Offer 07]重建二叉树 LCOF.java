//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 递归 
// 👍 445 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return build(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    TreeNode build(int preSt, int preEnd, int[] preorder, int inSt, int inEnd, int[] inorder) {
        if (preSt > preEnd) return null;
        int rootVal = preorder[preSt];
        TreeNode root = new TreeNode(rootVal);
        if (preSt == preEnd) {
            return root;
        }

        int pivot = inSt;
        while (inorder[pivot] != rootVal) {
            pivot++;
        }

        int leftLen = pivot - inSt;
        root.left = build(preSt + 1 , preSt + leftLen, preorder, inSt, pivot - 1, inorder);
        root.right = build(preSt + leftLen + 1, preEnd, preorder, pivot + 1, inEnd, inorder);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

pre: r, ..., ...
in : ... r ....
 */
