/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Integer, boolean[]> diff = new HashMap<>();
        UnionFind unionFind = new UnionFind(diff);

        for (String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            boolean equals = s.charAt(1) == '=';
            if (x == y) {
                if (equals) {
                    continue;
                } else {
                    return false;
                }
            }
            int rootX = unionFind.root(x);
            int rootY = unionFind.root(y);
            if (equals) {
                boolean isBelongToDiffSet = (diff.containsKey(rootX) && diff.get(rootX)[rootY]) ||
                                            (diff.containsKey(rootY) && diff.get(rootY)[rootX]);
                if (isBelongToDiffSet) {
                    return false;
                }
                unionFind.join(x, y);
            } else {
                if (rootX == rootY) {
                    return false;
                }
                diff.computeIfAbsent(rootX, v -> new boolean[26]);
                diff.get(rootX)[rootY] = true;
                diff.computeIfAbsent(rootY, v -> new boolean[26]);
                diff.get(rootY)[rootX] = true;
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent = new int[26];
        int[] rank = new int[26];
        Map<Integer, boolean[]> diff;

        UnionFind(Map<Integer, boolean[]> diff) {
            this.diff = diff;
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
                    diff.put(x, diff.get(y));
                } else if (rank[x] < rank[y]) {
                    parent[x] = y;
                    diff.put(y, diff.get(x));
                } else {
                    parent[x] = y; 
                    rank[y]++;
                }
            }
        }

        int root(int x) {
            if (parent[x] != x) {
                parent[x] = root(parent[x]);
            }
            return parent[x];
        }
    }
}
// @lc code=end

