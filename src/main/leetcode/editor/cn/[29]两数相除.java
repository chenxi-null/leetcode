//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
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
// Note: 
//
// 
// Both dividend and divisor will be 32-bit signed integers. 
// The divisor will never be 0. 
// Assume we are dealing with an environment which could only store integers wit
//hin the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pr
//oblem, assume that your function returns 231 − 1 when the division result overfl
//ows. 
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }

        if (dividend == 0) {
            return 0;
        }

        boolean negative = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0);
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        int res = calc(dividend, divisor);
        return negative ? -res : res;
    }

    private int calc(int dividend, int divisor) {
        if (dividend < divisor) {
            return 0;
        }
        int r = 1;
        int pd = divisor;
        int d = divisor;
        while ((d = pd << 2) <= dividend && d > 0) {
            r <<= 2;
            pd = d;
        }
        return r + calc(dividend - pd, divisor);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
