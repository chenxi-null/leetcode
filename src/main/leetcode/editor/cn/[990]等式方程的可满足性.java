//Given an array equations of strings that represent relationships between varia
//bles, each string equations[i] has length 4 and takes one of two different forms
//: "a==b" or "a!=b". Here, a and b are lowercase letters (not necessarily differe
//nt) that represent one-letter variable names. 
//
// Return true if and only if it is possible to assign integers to variable name
//s so as to satisfy all the given equations. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is sat
//isfied, but not the second.  There is no way to assign the variables to satisfy 
//both equations.
// 
//
// 
// Example 2: 
//
// 
//Input: ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Example 3: 
//
// 
//Input: ["a==b","b==c","a==c"]
//Output: true
// 
//
// 
// Example 4: 
//
// 
//Input: ["a==b","b!=c","c==a"]
//Output: false
// 
//
// 
// Example 5: 
//
// 
//Input: ["c==c","b==d","x!=z"]
//Output: true
// 
//
// 
//
// Note: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] and equations[i][3] are lowercase letters 
// equations[i][1] is either '=' or '!' 
// equations[i][2] is '=' 
// 
// 
// 
// 
// 
// 
// Related Topics 并查集 图


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
        List<String> notEquals = new LinkedList<>();

        for (String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            boolean equals = s.charAt(1) == '=';
            if (equals) {
                unionFind.join(x, y);
            } else {
                notEquals.add(s);
            }
        }
        for (String s : notEquals) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            if (unionFind.isConnected(x, y)) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent = new int[26];
        int[] rank = new int[26];

        UnionFind() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        void join(int _x, int _y) {
            int x = root(_x);
            int y = root(_y);
            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else {
                    parent[x] = y;
                    rank[y]++;
                }
            }
        }

        boolean isConnected(int x, int y) {
            return root(x) == root(y);
        }

        int root(int x) {
            if (parent[x] != x) {
                parent[x] = root(parent[x]);
            }
            return parent[x];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
