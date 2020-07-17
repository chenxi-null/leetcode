/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Stack<Pair> s = new Stack<>();

        for (int currIdx = 0; currIdx < n; currIdx++) {
            int currVal = a[currIdx];
            while (!s.isEmpty() && s.peek().val < currVal) {
                Pair e = s.pop();
                ans[e.idx] = currIdx - e.idx;
            }
            s.push(new Pair(currIdx, currVal));
        }
        return ans;
    }

    static class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
// @lc code=end

// #[Better] find the law by drawing

// not good solution (use TreeMap)
/*
    public int[] dailyTemperatures(int[] a) {
        int n = a.length;
        TreeMap<Integer, List<Integer>> valToIdxMap = new TreeMap<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                Map.Entry<Integer, List<Integer>> e = valToIdxMap.lowerEntry(a[i]);
                if (e == null) {
                    break;
                }
                int val = e.getKey();
                List<Integer> idxList = e.getValue();
                for (int idx : idxList) {
                    ans[idx] = i - idx;
                }
                valToIdxMap.remove(val);
            }

            valToIdxMap.computeIfAbsent(a[i], k -> new LinkedList<>());
            valToIdxMap.get(a[i]).add(i);
        }
        return ans;
    }
 */
