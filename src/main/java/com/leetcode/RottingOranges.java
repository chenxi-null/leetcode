package com.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/3/4
 */
/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

https://leetcode-cn.com/problems/rotting-oranges
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int numRotten = countRotten(grid);
        int numTotal = countTotal(grid);
        Queue<Node> q = initQueue(grid);
        int currLevel = 0;
        while (numRotten < numTotal && !q.isEmpty()) {
            Node o = q.remove();
            if (o.level > currLevel) {
                ++currLevel;
            }

            // rotten around
            int[][] a = new int[][]{
                    new int[]{o.x, o.y + 1},
                    new int[]{o.x, o.y - 1},
                    new int[]{o.x + 1, o.y},
                    new int[]{o.x - 1, o.y}};

            for (int[] t: a) {
                int i = t[0];
                int j = t[1];
                if (rot(i, j, grid)) {
                    ++numRotten;
                    q.add(new Node(i, j, currLevel + 1));
                }
            }
        }

        return (numRotten < numTotal) ? -1 : currLevel;
    }

    boolean rot(int x, int y, int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= column) return false;

        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            return true;
        } else {
            return false;
        }
    }

    private Queue<Node> initQueue(int[][] grid) {
        Queue<Node> q = new LinkedBlockingQueue<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 1));
                }
            }
        }
        return q;
    }

    private int countTotal(int[][] grid) {
        int r = 0;
        for (int[] rows : grid) {
            for (int e : rows) {
                if (e == 1 || e == 2) {
                    ++r;
                }
            }
        }
        return r;
    }

    private int countRotten(int[][] grid) {
        int r = 0;
        for (int[] rows : grid) {
            for (int e : rows) {
                if (e == 2) {
                    ++r;
                }
            }
        }
        return r;
    }

    private static class Node {
        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
