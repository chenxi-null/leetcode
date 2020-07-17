/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    /*
    a[l] == 0 
    a[i] != 0 | i < l
    a[j] == 0 | l <= j < r
    */
    public void moveZeroes(int[] a) {
        int l = 0;
        for (; l < a.length; l++) {
            if (a[l] == 0) break;
        }
        if (l == a.length) return;

        for (int r = l + 1; r < a.length; r++) {
            if (a[r] != 0) {
                swap(a, r, l);
                l++;
            }
        }
    }

    void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}
// @lc code=end
/*
      -     -
x x x o o o *

      -     -
x x x o o o x *

        -     -
x x x o x o o *

---

1 2 0 3 4 0

- -
0 1 0 2 3 0 4 0 0 5

  -   -
1 0 0 2

    -   _
1 2 0 0 3
 */
