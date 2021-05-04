//Given a rows x cols binary matrix filled with 0's and 1's, find the largest re
//ctangle containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
// 
//
// Example 2: 
//
// 
//Input: matrix = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: matrix = [["1"]]
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: matrix = [["0","0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// rows == matrix.length 
// cols == matrix[i].length 
// 0 <= row, cols <= 200 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 898 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int[][] arr = new int[nrow][];
        for (int i = 0; i < nrow; i++) {
            arr[i] = new int[ncol];
        }
        for (int c = 0; c < ncol; c++) {
            for (int r = 0; r < nrow; r++) {
                if (matrix[r][c] == '0') {
                    arr[r][c] = 0;
                } else {
                    arr[r][c] = (r == 0 ? 0 : arr[r - 1][c]) + 1;
                }
            }
        }

        int n = ncol;
        Stack<Integer> stk = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int r = 0; r < nrow; r++) {
            int[] h = arr[r];
            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && h[stk.peek()] >= h[i]) {
                    stk.pop();
                }
                left[i] = stk.isEmpty() ? 0 : stk.peek() + 1;
                stk.push(i);
            }
            stk.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stk.isEmpty() && h[stk.peek()] >= h[i]) {
                    stk.pop();
                }
                right[i] = stk.isEmpty() ? n - 1 : stk.peek() - 1;
                stk.push(i);
            }
            stk.clear();
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (right[i] - left[i] + 1) * h[i]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
