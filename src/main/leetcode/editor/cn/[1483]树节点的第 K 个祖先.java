//You are given a tree with n nodes numbered from 0 to n-1 in the form of a pare
//nt array where parent[i] is the parent of node i. The root of the tree is node 0
//. 
//
// Implement the function getKthAncestor(int node, int k) to return the k-th anc
//estor of the given node. If there is no such ancestor, return -1. 
//
// The k-th ancestor of a tree node is the k-th node in the path from that node 
//to the root. 
//
// 
//
// Example: 
//
// 
//
// 
//Input:
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//Output:
//[null,1,0,-1]
//
//Explanation:
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // returns 1 which is the parent of 3
//treeAncestor.getKthAncestor(5, 2);  // returns 0 which is the grandparent of 5
//
//treeAncestor.getKthAncestor(6, 3);  // returns -1 because there is no such anc
//estor
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 5*10^4 
// parent[0] == -1 indicating that 0 is the root node. 
// 0 <= parent[i] < n for all 0 < i < n 
// 0 <= node < n 
// There will be at most 5*10^4 queries. 


//leetcode submit region begin(Prohibit modification and deletion)
class TreeAncestor {

    List<List<Integer>> dp;

    // f(i, j) = f( f(i, j-1), j-1 )
    public TreeAncestor(int n, int[] parent) {
        dp = new ArrayList<>(parent.length);
        for (int i = 0; i < parent.length; i++) {
            dp.add(new ArrayList<>());
            dp.get(i).add(parent[i]);
        }
        for (int j = 1; ; j++) {
            boolean end = true;
            for (int i = 0; i < parent.length; i++) {
                int t = dp.get(i).get(j - 1) != -1 ? dp.get(dp.get(i).get(j - 1)).get(j - 1) : -1;
                dp.get(i).add(t);
                if (t != -1) {
                    end = false;
                }
            }
            if (end) break;
        }
    }

    public int getKthAncestor(int node, int k) {
        String s = Integer.toBinaryString(k);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (node == -1) {
                return -1;
            }
            int d = s.length() - 1 - i;
            if (s.charAt(i) == '1') {
                if (d >= dp.get(node).size()) {
                    return -1;
                }
                node = dp.get(node).get(d);
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
//leetcode submit region end(Prohibit modification and deletion)
