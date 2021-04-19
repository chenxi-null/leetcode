package com.leetcode.misc;//Given two integers dividend and divisor, divide two integers without using mul
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
        /*
    // bs:
        a[l], a[r]
        a[l|r]
        a[r], a[l]

        1.5
        1, 2

        e.g.:
        (10, 3)
        l, m, r,   a[m]
        0, 5, 10,  15 > 10
        0, 2, 4    6 < 10
        3, 3, 4    9 < 10
        4, 4, 4    12 > 10
        4, _, 3

        (1, 1)
        l, m, r,   a[m]
        0, 0, 1    0 < 1
        1, 1, 1    1 == 1

        (4, 1)
        l, m, r,   a[m]
        0, 2, 4    2 < 4
        3, 3, 4
        4, 4, 4
         */

    private int abs(int a) {
        return Math.abs(a);
    }

    public int divide(int dividend, int divisor) {
        boolean hasSign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            divisor = Integer.MAX_VALUE;
        }

        if (abs(dividend) < abs(divisor) ||
                dividend == 0 ||
                divisor == 0) {
            return 0;
        }

        int left = 0;
        int right = abs(dividend);
        int ans;
        while (true) {
            if (left > right) {
                ans = right;
                break;
            }
            int mid = (left + right) / 2;
            int midVal = mid * abs(divisor);
            int target = abs(dividend);
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
}
//leetcode submit region end(Prohibit modification and deletion)
