package com.leetcode.misc;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/16
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length < 1
                || matrix[0] == null || matrix[0].length < 1) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int r1 = 0;
        int r2 = m - 1;
        int c1 = 0;
        int c2 = n - 1;

        while (r1 < r2) {
            for (int i = c1; i < c2; i++) {
                int j = c1 + c2 - i;
                int t = matrix[j][c1];
                matrix[j][c1] = matrix[r2][j];
                matrix[r2][j] = matrix[i][c2];
                matrix[i][c2] = matrix[r1][i];
                matrix[r1][i] = t;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
    }
}

/*
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

a b c a
c x x b
b x x c
a c b a

n, swap
4,3

a b c x a
x x x x b
c x x x c
b x x x x
a x c b a


 */
