/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    char[][] board;
    String word;
    int m, n;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int offset = 'z' - 'A' + 1;

    boolean backtrack(int idx, int x, int y) {
        if (board[x][y] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }

        board[x][y] -= offset;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < m && nY >= 0 && nY < n) {
                if (board[nX][nY] >= 'A') {
                    if (backtrack(idx + 1, nX, nY)) {
                        return true;
                    }
                }
            }
        }
        board[x][y] += offset;
        return false;
    }
}
// @lc code=end

/*
#[WA] wrong exit of recursion search
without: try with example case & consider the corner case
 */

