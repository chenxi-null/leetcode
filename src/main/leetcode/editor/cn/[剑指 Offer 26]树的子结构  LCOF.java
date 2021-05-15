//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
//限制：
//0 <= 节点个数 <= 10000
//
//. Related Topics 树 
// 👍 270 👎 0


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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        if (recur(A, B)) return true;
        if (A.left != null && isSubStructure(A.left, B)) return true;
        if (A.right != null && isSubStructure(A.right, B)) return true;
        return false;
    }

    boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
#[WA] 对子结构的理解偏差
---
A: 1 2 1 2 1 2 ... 1 2 3
B: 1 2 3
*/