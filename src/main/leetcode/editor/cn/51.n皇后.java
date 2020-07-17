/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.table = new boolean[n][n];
        this.column_queens = new boolean[n];
        this.slash_queens = new boolean[2 * n - 1];
        this.backslash_queens = new boolean[2 * n - 1];

        dfs(0);
        return solutions;
    }

    private int n;
    private boolean[][] table;
    private List<List<String>> solutions = new LinkedList<>();
    private boolean[] column_queens;
    private boolean[] slash_queens;
    private boolean[] backslash_queens;

    private void dfs(int r) {
        for (int c = 0; c < n; c++) {
            boolean isValid = !(column_queens[c]) &&
                    !(backslash_queens[r - c + n - 1]) &&
                    !(slash_queens[r + c]);
            if (isValid) {
                table[r][c] = true;

                // update conflict stats
                column_queens[c] = true;
                backslash_queens[r - c + n - 1] = true;
                slash_queens[r + c] = true;

                if (r + 1 < n) {
                    dfs(r + 1);
                } else {
                    // generate a solution
                    List<String> list = new ArrayList<>(n);
                    for (int i = 0; i < table.length; i++) {
                        boolean[] a = table[i];
                        StringBuilder sb = new StringBuilder();
                        for (boolean b : a) {
                            sb.append(b ? 'Q' : '.');
                        }
                        list.add(sb.toString());
                    }
                    solutions.add(list);
                }

                table[r][c] = false;

                // reset conflict stats
                column_queens[c] = false;
                backslash_queens[r - c + n - 1] = false;
                slash_queens[r + c] = false;
            }
        }
    }
}
// @lc code=end


/*

hill diagonals /: r + c
dale diagonals \: r - c + n - 1

n: 4
2n - 1: 7

-3, -2, -1, 0, 1, 2, 3

0, 1, 2, 3 .. 6

(0,0) (0,1) (0,2), (0,3)
(1,0) (1,1) (1,2), (1,3)
(2,0) (2,1) (2,2), (2,3)
(3,0) (3,1) (3,2), (3,3)

0 1 2 3
1 - * #
2 * - *
3 # * -

 */
