package com.leetcode.array;

class SearchMatrixII {
    /*
    U  x
    *  R
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1
                || matrix[0] == null || matrix[0].length < 1) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int r = m - 1;
        int c = 0;
        while (c < n && r >= 0) {
            if (matrix[r][c] > target) {
                r--;
            } else if (matrix[r][c] < target) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }
}