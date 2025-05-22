/*
 * @lc app=leetcode.cn id=3362 lang=java
 *
 * [3362] Zero Array Transformation III
 * #Tag/DifferenceArray
 * #Tag/PriorityQueue
 * #Tag/Greedy
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        // For each nums[i], find all queries whose left endpoint is less than nums[i].
        // We just need nums[i] queries, use the greedy strategy
        //  which means the bigger right endpoints is prior.
        // Maintain a difference array to determine whether satisfy the 'zero-transformation' condition.
        int n = nums.length;
        int[] diff = new int[n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int j = 0;
        int opt = 0;
        for (int i = 0; i < n; i++) {
            opt += diff[i];
            while (j < queries.length && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }
            while (opt < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                opt++;
                int right = pq.poll();
                diff[right + 1]--;
            }
            if (opt < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
// @lc code=end

