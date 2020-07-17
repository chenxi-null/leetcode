/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        backtrack(0, k, n, new LinkedList<>(), used);
        return ans;
    }

    int idx = 0;
    String ans;

    void backtrack(int lvl, int k, int n, 
                   LinkedList<Integer> path, boolean[] used) {

        if (ans != null) {
            return;
        }
        if (lvl == n) {
            idx++;
            if (idx == k) {
                // path -> string
                StringBuilder sb = new StringBuilder();
                for (Integer num : path) {
                    sb.append(num.toString());
                }
                ans = sb.toString();
            }
            return; 
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                int num = i + 1;
                path.add(num);
                used[i] = true;
                backtrack(lvl + 1, k, n, path, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
// @lc code=end