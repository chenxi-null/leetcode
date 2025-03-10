/*
 * @lc app=leetcode.cn id=2269 lang=java
 *
 * [2269] Find the K-Beauty of a Number
 */

// @lc code=start
class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        char[] a = s.toCharArray();
        int ans = 0;
        int val = k-1 > 0 ? Integer.parseInt(s.substring(0, k-1)) : 0;
        for (int i = k-1; i < a.length; i++) {
            val -= i-k >= 0 ? ((a[i-k] - '0') * power(10, k-1)) : 0;
            val *= 10;
            val += (a[i] - '0');
            if (val != 0 && num % val == 0) {
                ans++;
            }
        }
        return ans;       
    }

    int power(int base, int e) {
        int r = 1;
        while (e-- > 0) {
            r *= base;
        }
        return r;
    }
}
// @lc code=end

