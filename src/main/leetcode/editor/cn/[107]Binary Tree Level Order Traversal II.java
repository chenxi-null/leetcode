//Given the root of a binary tree, return the bottom-up level order traversal of
// its nodes' values. (i.e., from left to right, level by level from leaf to root)
//. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[15,7],[9,20],[3]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
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
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 435 👎 0


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<E> q = new LinkedList<>();
        int prevLvl = 0;
        q.offer(new E(root, 1));
        while (!q.isEmpty()) {
            // pop the element from head of queue
            // add into result list
                // create a new inner list if current level is diff from previous
                // append the element into the last inner list if same
            E cur = q.poll();
            if (cur.lvl != prevLvl) {
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(cur.node.val);
            prevLvl = cur.lvl;

            // offer its left and right node into tail of queue
            if (cur.node.left != null) q.offer(new E(cur.node.left, cur.lvl + 1));
            if (cur.node.right != null) q.offer(new E(cur.node.right, cur.lvl + 1));
        }
        Collections.reverse(ans);
        return ans;
    }

    static class E {
        TreeNode node;
        int lvl;

        E (TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
1 2 2 3 3 3
 */
