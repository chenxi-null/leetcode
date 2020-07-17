package com.leetcode.misc;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

---

a a a b
d     b
d c c c

left, down, right, up

startRow
endRow

 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class SpiralOrder {


    // cleaner solution: less condition statement & shorter variable naming
    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return Collections.emptyList();
        }

        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int r1 = 0;
        int r2 = m - 1;
        int c1 = 0;
        int c2 = n - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                res.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2 - 1; r++) {
                res.add(matrix[r][c2]);
            }
            if (r1 < r2) {
                for (int c = c2; c >= c1; c--) {
                    res.add(matrix[r2][c]);
                }
            }
            if (c1 < c2) {
                for (int r = r2 - 1; r >= r1 + 1; r--) {
                    res.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
    /*

    c1    c2
 r1 - - - -
    |     |
    |     |
 r2 - - - -
     */


    public List<Integer> _spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return Collections.emptyList();
        }

        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;
        while (startRow <= endRow && startCol <= endCol) {
            if (startRow == endRow) {
                for (int i = startCol; i <= endCol; i++) {
                    res.add(matrix[startRow][i]);
                }
                break;
            } else if (startCol == endCol) {
                for (int i = startRow; i <= endRow; i++) {
                    res.add(matrix[i][startCol]);
                }
                break;
            }

            // right
            for (int i = startCol; i <= endCol - 1; i++) {
                res.add(matrix[startRow][i]);
            }
            // down
            for (int i = startRow; i <= endRow - 1; i++) {
                res.add(matrix[i][endCol]);
            }
            // left
            for (int i = endCol; i >= startCol + 1; i--) {
                res.add(matrix[endRow][i]);
            }
            // up
            for (int i = endRow; i >= startRow + 1; i--) {
                res.add(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return res;
    }
}
/*
->  down <- up

corner cases:
1.
startRow == endRow
* * * *
- - - |

2.
startCol == endCol
*
*
*

3.
*

---
a a a b
d     b
d c c c
*/
