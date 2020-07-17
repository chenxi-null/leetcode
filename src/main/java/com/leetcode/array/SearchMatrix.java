package com.leetcode.array;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

https://leetcode-cn.com/problems/search-a-2d-matrix
 */

class SearchMatrix {
    /*
    (0,0) (n-1,m-1)
    compare
    calculate mid

    1,x - 3,y
    1,x - 2,y
    1,x - 1.y

    2d -> 1d
        18 + 13 = 31
        31 / 2 = 15
    1d -> 2d
     */

    static int n;
    static int m;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length < 1) {
            return false;
        }
        if (null == matrix[0] || matrix[0].length < 1) {
            return false;
        }
        n = matrix.length;
        m = matrix[0].length;

        Point left = Point.of(0, 0);
        Point right = Point.of(n - 1, m - 1);

        while (left.lessThanOrEqual(right)) {
            Point mid = calcMiddle(left, right);
            //System.out.println(left + " | " + right);
            //System.out.println(mid);
            int v = matrix[mid.x][mid.y];
            if (v == target) {
                return true;
            } else if (v < target) {
                left = mid.plusOne();
            } else {
                right = mid.minusOne();
            }
        }
        return false;
    }

    private Point calcMiddle(Point a, Point b) {
        int mid = ((a.x + b.x) * m + a.y + b.y) / 2;
        return new Point(mid / m, mid % m);
    }

    private static class Point {
        int x;
        int y;

        public static Point of(int x, int y) {
            return new Point(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean lessThanOrEqual(Point p) {
            if (this.x < p.x) {
                return true;
            } else if (this.x > p.x) {
                return false;
            } else {
                return this.y <= p.y;
            }
        }

        public Point minusOne() {
            if (this.y - 1 >= 0) {
                return new Point(this.x, this.y - 1);
            } else {
                return new Point(this.x - 1, m - 1);
            }
        }

        public Point plusOne() {
            if ((this.y + 1) < m) {
                return new Point(this.x, this.y + 1);
            } else {
                return new Point(this.x + 1, 0);
            }
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }
    }
}