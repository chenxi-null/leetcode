package com.leetcode.misc;

//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Note: Assume we are dealing with an environment that could only store integer
//s within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, ass
//ume that your function returns 231 − 1 when the division result overflows. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Example 3: 
//
// 
//Input: dividend = 0, divisor = 1
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: dividend = 1, divisor = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics 数学 二分查找 
// 👍 556 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class DivideTwoIntegers {

    public int divide(int a, int b) {
        boolean hasSign = (a > 0 && b < 0) || (a < 0 && b > 0);

        if (a == Integer.MAX_VALUE && b == Integer.MIN_VALUE) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == 1) {
            return Integer.MIN_VALUE;
        }

        if (a == Integer.MIN_VALUE) a = Integer.MAX_VALUE;
        if (b == Integer.MIN_VALUE) b = Integer.MAX_VALUE;
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        if (a < b || a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return hasSign ? -a : a;
        }

        int left = 0;
        int right = a;
        int ans;
        while (true) {
            if (left > right) {
                ans = right;
                break;
            }
            int mid = left + (right - left) / 2;
            int midVal = mul(mid, b);
            //System.out.println("l, m, r, a[m] " + left + ", " + mid + ", " + right + ", " + midVal);
            int target = a;
            if (midVal < 0 || midVal > target) {
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return hasSign ? -ans : ans;
    }

    //todo
    private int mul(int x, int y) {
        long ans = ((long) (x)) * ((long) (y));
        if (ans > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
