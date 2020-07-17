package com.leetcode.array;
/*
https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode/
 */

class SetMatrixZeroes {

    /*
    x x x x
    x x x x
    x x x x
    x x x x

       m

     x x 0 x
     x x x x
  n  x x 0 x
     0 x 0 x

     */
    public void setZeroes(int[][] matrix) {

        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        if (n < 1) {
            return;
        }
        int m = matrix[0].length;
        if (m < 1) {
            return;
        }

        // set flags
        boolean setFirstRow = false;
        boolean setFirstColumn = false;
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                setFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                setFirstColumn = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set zeros
        for (int i = 1; i < n; i++) {
            if ((matrix[i][0] == 0)) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (setFirstRow) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (setFirstColumn) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}