//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related peekics 栈 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        // store index
        int[] left = new int[n];
        int[] right = new int[n];

        // store index, a[index] is monotonic increasing
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? 0 : s.peek() + 1;
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n - 1 : s.peek() - 1;
            s.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cand = a[i] * (right[i] - left[i] + 1);
            max = Math.max(max, cand);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
