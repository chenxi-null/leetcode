//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any sequence of nodes from some starting
// node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the root.
//
// Example 1: 
//
// 
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return (int) ans;
    }

    private long ans = Long.MIN_VALUE;

    int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lm = findMax(root.left);
        int rm = findMax(root.right);
        int v = root.val;
        int max = v;
        max = Math.max(max, v + lm);
        max = Math.max(max, v + rm);

        ans = Math.max(ans, max);
        ans = Math.max(ans, lm + v + rm);
        return max;
    }

    /*
    - l root r
    - l root
    -   root r
    -   root
     */
}
//leetcode submit region end(Prohibit modification and deletion)
