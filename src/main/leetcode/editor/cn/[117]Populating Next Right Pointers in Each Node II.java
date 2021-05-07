//Given a binary tree 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
//
// Follow up: 
//
// 
// You may only use constant extra space. 
// Recursive approach is fine, you may assume implicit stack space does not coun
//t as extra space for this problem. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should popu
//late each next pointer to point to its next right node, just like in Figure B. T
//he serialized output is in level order as connected by the next pointers, with '
//#' signifying the end of each level.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is less than 6000. 
// -100 <= node.val <= 100 
// 
// Related Topics 树 深度优先搜索 
// 👍 399 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        help(root);
        return root;
    }

    private void help(Node root) {
        Node p = root;
        Node downHead = null;
        Node downCurr = null;
        Node downPrev = null;
        while (p != null) {
            if (p.left != null || p.right != null) {
                if (p.left != null) {
                    if (p.right != null) {
                        p.left.next = p.right;
                    }
                    downCurr = p.left;
                } else {
                    downCurr = p.right;
                }

                if (downHead == null) {
                    downHead = downCurr;
                }
                if (downPrev != null) {
                    downPrev.next = downCurr;
                }
                downPrev = p.right != null ? p.right : p.left;
            }

            p = p.next;
        }

        if (downHead != null) {
            help(downHead);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//#[Better]: more simple code
// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/
