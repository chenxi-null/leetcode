//You are given a 2D matrix of size m x n, consisting of non-negative integers.
//You are also given an integer k.
//
// The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] w
//here 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
//
// Find the kth largest value (1-indexed) of all the coordinates of matrix.
//
//
// Example 1:
//
//
//Input: matrix = [[5,2],[1,6]], k = 1
//Output: 7
//Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the larges
//t value.
//
// Example 2:
//
//
//Input: matrix = [[5,2],[1,6]], k = 2
//Output: 5
//Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest
//value.
//
// Example 3:
//
//
//Input: matrix = [[5,2],[1,6]], k = 3
//Output: 4
//Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd la
//rgest value.
//
// Example 4:
//
//
//Input: matrix = [[5,2],[1,6]], k = 4
//Output: 0
//Explanation: The value of coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which i
//s the 4th largest value.
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 1000
// 0 <= matrix[i][j] <= 106
// 1 <= k <= m * n
//
// Related Topics 数组
// 👍 66 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthLargestValue(int[][] a, int k) {
        int m = a.length;
        int n = a[0].length;
        int[][] f = new int[m][];
        for (int i = 0; i < m; i++) {
            f[i] = new int[n];
        }
        PriorityQueue<Integer> q= new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (i - 1 < 0 ? 0 : f[i - 1][j])
                        ^ (j - 1 < 0 ? 0 : f[i][j - 1])
                        ^ (i - 1 < 0 || j - 1 < 0 ? 0 : f[i - 1][j - 1])
                        ^ a[i][j];
                q.offer(f[i][j]);
            }
        }
        for (int i = 0; i < n * m - k; i++)
            q.poll();
        return q.peek();
    }
}
/*
f[i,j] = f[i-1,j] ^ f[i,j-1] ^ f[i–1][j-1] ^ a[i][j]
*/
//leetcode submit region end(Prohibit modification and deletion)
