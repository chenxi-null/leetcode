//A path in a binary tree is a sequence of nodes where each pair of adjacent nod
//es in the sequence has an edge connecting them. A node can only appear in the se
//quence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1043 👎 0


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
    public int maxPathSum(TreeNode root) {
        find(root);
        return ans;
    }

    int ans = -1000 - 1;

    // return: the sum of the max-sum-path that takes the current node as highest node
    public int find(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val;
        int ls = find(root.left);
        int rs = find(root.right);
        if (ls > 0 || rs > 0) {
            sum += Math.max(ls, rs);
        }

        // try to update answer
        int cand = root.val + (ls > 0 ? ls : 0) + (rs > 0 ? rs : 0);
        ans = Math.max(ans, cand);

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA]: 题意理解错误, path 不是树的子结构