//You are given a 0-indexed binary string s and two integers minJump and maxJump
//. In the beginning, you are standing at index 0, which is equal to '0'. You can
//move from index i to index j if the following conditions are fulfilled:
//
//
// i + minJump <= j <= min(i + maxJump, s.length - 1), and
// s[j] == '0'.
//
//
// Return true if you can reach index s.length - 1 in s, or false otherwise.
//
//
// Example 1:
//
//
//Input: s = "011010", minJump = 2, maxJump = 3
//Output: true
//Explanation:
//In the first step, move from index 0 to index 3.
//In the second step, move from index 3 to index 5.
//
//
// Example 2:
//
//
//Input: s = "01101110", minJump = 2, maxJump = 3
//Output: false
//
//
//
// Constraints:
//
//
// 2 <= s.length <= 105
// s[i] is either '0' or '1'.
// s[0] == '0'
// 1 <= minJump <= maxJump < s.length
//
// Related Topics 贪心算法 广度优先搜索 Line Sweep
// 👍 16 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;
    public boolean canReach(String s, int minJump, int maxJump) {
        int low = 0, high = 0;
        int nextLow = MAX;
        int nextHigh = MIN;
        char[] a = s.toCharArray();
        int n = a.length;
        if (a[n - 1] != '0') {
            return false;
        }
        for (int i = 0; i < n; ) {
            System.out.println(i + ", [" + low + "," + high + "], [" + nextLow + "," + nextHigh + "]");
            if (i <= high) {
                if (a[i] == '0') {
                    if (i + maxJump > high) {
                        nextLow = Math.min(nextLow, Math.max(high + 1, i + minJump));
                        nextHigh = Math.max(nextHigh, i + maxJump);
                    }
                    if (nextHigh >= n - 1 && n - 1 >= nextLow) {
                        return true;
                    }
                }
                i++;
            } else {
                if (nextLow == MAX) {
                    System.out.println(">>>");
                    System.out.println("i: " + i);
                    return false;
                }
                low = nextLow;
                high = nextHigh;
                i = nextLow;
                nextLow = MAX;
            }
        }
        //System.out.println("---->>>");
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
0 1 2 3 4 5 6 7 8 9
0 0 0 1 0 0 1 0 0 0 1 0
- --- --- --- -

0 1 2 3 4 5 6 7 8 9
0 1 1 1 1 1 1 1 0 1 1 1 1 0
- -----------------

"01111111011110"
1
9
"00111010"
3
5
"000100100010"
1
2
"011010"
2
3
"01101110"
2
3
"01"
1
1

 */
