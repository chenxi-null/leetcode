//Given the root of a binary tree and an integer targetSum, return all root-to-l
//eaf paths where each path's sum equals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 
// 👍 482 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, null);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    int targetSum;

    void dfs(TreeNode root, List<Integer> prevPath) {
        if (root == null) return;

        // create the current path
        List<Integer> curPath = prevPath == null ? new ArrayList<>() : new ArrayList<>(prevPath);
        curPath.add(root.val);

        if (root.left == null && root.right == null) {
            // sum of current path
            int sum = 0;
            for (int x : curPath) {
                sum += x;
            }
            if (sum == targetSum) {
                ans.add(curPath);
            }
            return;
        }
        if (root.left != null) dfs(root.left, curPath);
        if (root.right != null) dfs(root.right, curPath);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
