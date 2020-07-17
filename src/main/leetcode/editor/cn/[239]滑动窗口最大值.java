//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
//


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        // store index of nums
        Deque<Integer> q = new LinkedList<>();
        // the max values
        int[] ans = new int[a.length - k + 1];
        int i = 0;
        int l = 0, r = 0;
        for (; r < a.length; r++) {
            while (!q.isEmpty() && a[q.getLast()] <= a[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (r >= k) {
                if (q.getFirst() == l) {
                    q.removeFirst();
                }
                l++;
            }
            if (r >= k - 1) {
                ans[i++] = a[q.getFirst()];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
