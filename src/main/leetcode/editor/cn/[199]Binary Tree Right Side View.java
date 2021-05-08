//Given the root of a binary tree, imagine yourself standing on the right side o
//f it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 454 👎 0


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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.singletonList();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(1, root));
        while (!q.isEmpty()) {
            Data e = q.poll();
            if (e.node.left != null) {
                q.offer(new Data(e.lvl + 1, e.node.left));
            }
            if (e.node.right != null) {
                q.offer(new Data(e.lvl + 1, e.node.right));
            }
            if (q.isEmpty() || e.lvl != q.peek().lvl) {
                ans.add(e.node.val);
            }
        }
        return ans;
    }

    private static class Data {
        int lvl;
        TreeNode node;

        public Data(int lvl, TreeNode node) {
            this.lvl = lvl;
            this.node = node;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
queue:
1
2l 2r
2r 3 3

1 2 2 3 3 3 4 4 4
 */
