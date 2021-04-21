//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 
// 👍 1323 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            int h = (i < n) ? a[i] : 0;
            while (!stk.isEmpty() && h <= a[stk.peek()]) {
                int pi = stk.pop();
                int li = (stk.isEmpty()) ? 0 : stk.peek() + 1;
                left[pi] = li;
            }
            if (i < n) stk.push(i);
        }
        for (int i = n - 1; i >= -1; i--) {
            int h = (i > -1) ? a[i] : 0;
            while (!stk.isEmpty() && h <= a[stk.peek()]) {
                int pi = stk.pop();
                int ri = stk.isEmpty() ? n - 1 : stk.peek() - 1;
                right[pi] = ri;
            }
            if (i > -1) stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * a[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
