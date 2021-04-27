//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] a) {
        UnionFind uf = new UnionFind(a);
        int nrow = a.length;
        int ncol = a[0].length;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (a[i][j] == '1') {
                    int idx = i * ncol + j;
                    //right element
                    if (i + 1 < nrow && a[i + 1][j] == '1') {
                        uf.union(idx, (i + 1) * ncol + j);
                    }
                    // down element
                    if (j + 1 < ncol && a[i][j + 1] == '1') {
                        uf.union(idx, i * ncol + (j + 1));
                    }
                }
            }
        }
        return uf.getCount();
    }

    private static class UnionFind {
        int[] parent;
        int[] rank;
        int count = 0;

        public UnionFind(char[][] a) {
            int nrow = a.length;
            int ncol = a[0].length;
            parent = new int[nrow * ncol];
            rank = new int[nrow * ncol];
            for (int i = 0; i < nrow; i++) {
                for (int j = 0; j < ncol; j++) {
                    int idx = i * ncol + j;
                    parent[idx] = idx;
                    if (a[i][j] == '1') {
                        ++count;
                    }
                }
            }
        }

        private int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else if (rank[y] > rank[x]) {
                    parent[x] = y;
                } else {
                    parent[y] = x;
                    ++rank[x];
                }
                --count;
            }
        }

        public int getCount() {
            return this.count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA] 二维数组转一维: i * ncol + j, (错误写法: i * nrow + j)