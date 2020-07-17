//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 


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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left != null) {
            TreeNode tail1 = flat(root.left);
            TreeNode rc = root.right;
            root.right = root.left;
            root.left = null;
            if (rc != null) {
                TreeNode tail2 = flat(rc);
                tail1.right = rc;
                return tail2;
            } else {
                return tail1;
            }
        } else {
            TreeNode tail2 = flat(root.right);
            return tail2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA] low level error: missing operation - `root.left = null`