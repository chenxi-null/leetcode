//Given a rows x cols matrix grid representing a field of cherries. Each cell in
// grid represents the number of cherries that you can collect. 
//
// You have two robots that can collect cherries for you, Robot #1 is located at
// the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0,
// cols-1) of the grid. 
//
// Return the maximum number of cherries collection using both robots by followi
//ng the rules below: 
//
// 
// From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1
//). 
// When any robot is passing through a cell, It picks it up all cherries, and th
//e cell becomes an empty cell (0). 
// When both robots stay on the same cell, only one of them takes the cherries. 
//
// Both robots cannot move outside of the grid at any moment. 
// Both robots should reach the bottom row in the grid. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
//Output: 24
//Explanation: Path of robot #1 and #2 are described in color green and blue res
//pectively.
//Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
//Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
//Total of cherries: 12 + 12 = 24.
// 
//
// Example 2: 
//
// 
//
// 
//Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0] ,[1,0,2,3,0,0,6]]
//Output: 28
//Explanation: Path of robot #1 and #2 are described in color green and blue res
//pectively.
//Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
//Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
//Total of cherries: 17 + 11 = 28.
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
//Output: 22
// 
//
// Example 4: 
//
// 
//Input: grid = [[1,1],[1,1]]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// rows == grid.length 
// cols == grid[i].length 
// 2 <= rows, cols <= 70 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int r = 0; r < n; r++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    dp[r][c1][c2] = -1;
                }
            }
        }
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];

        for (int r = 1; r < n; r++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    int max = -1;
                    for (int i = c1 - 1; i <= c1 + 1; i++) {
                        for (int j = c2 - 1; j <= c2 + 1; j++) {
                            if (i < 0 || j < 0 || i >= m || j >= m
                                    || grid[r][i] < 0 || grid[r][j] < 0) {
                                continue;
                            }
                            max = Math.max(max, dp[r - 1][i][j]);
                        }
                    }
                    dp[r][c1][c2] = max < 0 ? -1 :
                            (c1 == c2 ? max + grid[r][c1] : max + grid[r][c1] + grid[r][c2]);
                }
            }
        }
        int ans = -1;
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = 0; c2 < m; c2++) {
                ans = Math.max(ans, dp[n - 1][c1][c2]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
#[WA] 1. ArrayIndexOutOfBoundsException & 2. misunderstand the question
(2.1 two robots are located at the top conner ; 2.2 tow robots can stand on the same cell)

---

1 0 1
0 1 0
2 0 2

[
[4,1,5,7,1],
[6,0,4,6,4],
[0,9,6,3,5]
]

Wrong Answer:
input:[[4,1,5,7,1],[6,0,4,6,4],[0,9,6,3,5]]
Output:38
Expected:32
stdout:
 */
