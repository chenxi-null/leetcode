/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132 模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stk = new LinkedList<>();
        Integer kVal = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int iVal = nums[i];
            while (!stk.isEmpty() && stk.peekLast() < iVal) {
                int t = stk.pollLast();
                kVal = Math.max(kVal, t);
            }
            if (!stk.isEmpty() && kVal > iVal) {
                return true;
            }
            stk.offerLast(iVal);
        }
        return false;
    }
}
// @lc code=end
/*
1 3 2
i j k


                |
                |
        | |     |
    |   | | .   |
  | | . | | . . |
  | | . | | . . |
  | | . | | . . |
<-----------------

|
|
|   | 
| . | 
| . |     | 
| . |   . | |
| . | . . | | 
---------------->
*/

