/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1, str.length());
        }
        str = new StringBuilder(str).reverse().toString();
        
        if (!negative) {
            if (greatThan(str, String.valueOf(Integer.MAX_VALUE))) {
                return 0;
            } else {
                return Integer.parseInt(str);
            }
        } else {
            String t = String.valueOf(Integer.MIN_VALUE);
            t = t.substring(1, t.length());
            if (greatThan(str, t)) {
                return 0;
            } else {
                return Integer.parseInt('-' + str);
            }
        }
    }

    private boolean greatThan(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        } else if (a.length() > b.length()) {
            return true;
        } else{
            return a.compareTo(b) > 0;
        }
    }
}
// @lc code=end

