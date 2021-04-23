//Given an integer n, return all the structurally unique BST's (binary search tr
//ees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 859 👎 0


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

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int st, int end) {
        if (st > end) {
            return Collections.singletonList(null);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int k = st; k <= end; k++) {
            List<TreeNode> leftList = dfs(st, k - 1);
            List<TreeNode> rightList = dfs(k + 1, end);
            for (int i = 0; i < leftList.size(); i++) {
                for (int j = 0; j < rightList.size(); j++) {
                    TreeNode node = new TreeNode(k);
                    node.left = leftList.get(i);
                    node.right = rightList.get(j);
                    res.add(node);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
1, ... k-1, k, k+1, ... n

countLeft * countRight
 */
