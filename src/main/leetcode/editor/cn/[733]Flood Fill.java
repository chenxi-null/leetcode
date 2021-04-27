//
//An image is represented by a 2-D array of integers, each integer representing 
//the pixel value of the image (from 0 to 65535).
// 
//Given a coordinate (sr, sc) representing the starting pixel (row and column) o
//f the flood fill, and a pixel value newColor, "flood fill" the image.
// 
//To perform a "flood fill", consider the starting pixel, plus any pixels connec
//ted 4-directionally to the starting pixel of the same color as the starting pixe
//l, plus any pixels connected 4-directionally to those pixels (also with the same
// color as the starting pixel), and so on. Replace the color of all of the aforem
//entioned pixels with the newColor.
// 
//At the end, return the modified image.
// 
// Example 1: 
// 
//Input: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: 
//From the center of the image (with position (sr, sc) = (1, 1)), all pixels con
//nected 
//by a path of the same color as the starting pixel are colored with the new col
//or.
//Note the bottom corner is not colored 2, because it is not 4-directionally con
//nected
//to the starting pixel.
// 
// 
//
// Note:
// The length of image and image[0] will be in the range [1, 50]. 
// The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < im
//age[0].length. 
// The value of each color in image[i][j] and newColor will be an integer in [0,
// 65535]. 
// Related Topics 深度优先搜索 
// 👍 179 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] floodFill(int[][] a, int sr, int sc, int newColor) {
        if (a == null || a.length == 0) {
            return a;
        }
        if (a[0] == null || a[0].length == 0) {
            return a;
        }
        this.nrow = a.length;
        this.ncol = a[0].length;
        this.ov = a[sr][sc];
        this.nv = newColor;
        if (ov == nv) {
            return a;
        }

        dfs(a, sr, sc);
        return a;
    }

    int nrow;
    int ncol;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int ov;
    int nv;

    void dfs(int[][] a, int x, int y) {
        if (a[x][y] == ov) {
            a[x][y] = nv;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < nrow &&
                    ny >= 0 && ny < ncol && a[nx][ny] == ov) {
                dfs(a, nx, ny);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
