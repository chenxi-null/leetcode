//The thief has found himself a new place for his thievery again. There is only 
//one entrance to this area, called the "root." Besides the root, each house has o
//ne and only one parent house. After a tour, the smart thief realized that "all h
//ouses in this place forms a binary tree". It will automatically contact the poli
//ce if two directly-linked houses were broken into on the same night. 
//
// Determine the maximum amount of money the thief can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
//
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//Output: 7 
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7. 
//
// Example 2: 
//
// 
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// Related Topics 树 深度优先搜索 

/*
Solution:

DP 递推表达式:

dp[root][0] 表示 对于 root 这个根节点，不抢劫时的收益最大值
dp[root][1] 表示 对于 root 这个根节点，施行抢劫时的收益最大值

dp[root][1] = dp[leftChild][0] + dp[rightChild] + root.val
dp[root][0] = max{dp[leftChild][0], dp[rightChild][1]} + max{dp[rightChild][0], dp[rightChild][1]}
 */


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
    public int rob(TreeNode root) {
        int[] t = dfs(root);
        return Math.max(t[0], t[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
