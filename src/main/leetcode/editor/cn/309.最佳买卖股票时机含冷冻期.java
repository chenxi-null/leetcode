/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] a) {
        int n = a.length;
        int ans = 0;
        int l = 0, r = 0;
        for (; r < n; r++) {
            if (r == n - 1) {
                ans += a[r] - a[l];
            } else if (a[r + 1] <= a[r]) {
                if (r + 2 < n && a[r + 2] > a[r + 1]) {
                    if (a[r + 1] >= a[l] && a[r + 2] >= a[r]) {
                        r++;
                    } else if (r == l) {
                        l = r + 1;
                    } else if (a[r] - a[r - 1] < a[r + 2] - a[r + 1]) {
                        ans += a[r - 1] - a[l];
                        l = r + 1;
                    } else {
                        ans += a[r] - a[l];
                        l = r + 2;
                        r++;
                    }
                } else {
                    ans += a[r] - a[l];
                    l = r + 1;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

/*
l, r, r+1, r+2



---

r + 2 >= r :
a
       b
   c
           d
---

a
         b
   c
      d

 */
