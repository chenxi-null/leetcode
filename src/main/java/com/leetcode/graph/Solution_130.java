package com.leetcode.graph;/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

class Solution_130 {
    public void solve(char[][] board) {
        int m = board.length;
        if (m <= 0) return;
        int n = board[0].length;
        if (n <= 0) return;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int dummyIdx = m * n;
        UnionFind unionFind = new UnionFind(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int currIdx = i * n + j;
                    boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                    if (isEdge) {
                        unionFind.union(currIdx, dummyIdx);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int nX = i + dx[k];
                            int nY = j + dy[k];
                            if (board[nX][nY] == 'O') {
                                unionFind.union(currIdx, nX * n + nY);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !unionFind.isConnected(i * n + j, dummyIdx)) {
                    board[i][j] = 'X';
                }
            }
        }
        debug(n, unionFind);
    }

    private void debug(int n, UnionFind unionFind) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>");
        System.out.print("-------- index -------");
        int[] a = unionFind.parent;
        for (int i = 0; i < a.length; i++) {
            if (i % n == 0) {
                System.out.println();
            }
            System.out.printf("%3d, ", i);
        }
        System.out.println();
        System.out.print("-------- parent -------");
        for (int i = 0; i < a.length; i++) {
            if (i % n == 0) {
                System.out.println();
            }
            System.out.printf("%3d, ", a[i]);
        }
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                // 路径压缩
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}

/*
[
["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","O","O","O","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","O","O","X","O","X","O","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","O","X","O","X","O","O","O","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","O","O","O","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","X","X","X","X","X","X","X","X","X","X","X","X","X"]]

["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","X","X","X","X","X","X","X","X","X","X","X","X","X"]]

["X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","X","X","X","X","O","O","O","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","O","O","X","O","X","O","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","O","X","O","X","O","O","O","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","O","O","O","X","X","X","X","X","X","X","X","X","X"],
["X","X","X","X","X","O","X","X","X","X","X","X","X","X","X","X","X","X","X","X"]]
*/
