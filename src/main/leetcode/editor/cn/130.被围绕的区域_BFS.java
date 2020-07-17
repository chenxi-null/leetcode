/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m <= 0) return;
        int n = board[0].length;
        if (n <= 0) return;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char charVisited = '*';
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ('O' == board[i][j]) {
                    boolean isSurrounded = true;
                    List<int[]> visited = new LinkedList<>();

                    Queue<int[]> q = new LinkedList<>();
                    board[i][j] = charVisited;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        visited.add(p);
                        for (int k = 0; k < 4; k++) {
                            int nX = p[0] + dx[k];
                            int nY = p[1] + dy[k];
                            if (nX >= 0 && nX < m && nY >= 0 && nY < n) {
                                if (board[nX][nY] == 'O') {
                                    board[nX][nY] = charVisited;
                                    q.offer(new int[]{nX, nY});
                                }
                            } else {
                                isSurrounded = false;
                            }
                        }
                    }
                    if (isSurrounded) {
                        for (int[] p : visited) {
                            board[p[0]][p[1]] = 'X';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == charVisited) {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
// @lc code=end

/*
  o
o o o o
  o
 */
