//Given an unsorted array of integers, find the length of the longest consecutiv
//e elements sequence. 
//
// Your algorithm should run in O(n) complexity. 
//
// Example: 
//
// 
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
// Related Topics 并查集 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] a) {
        int max = 0;
        // key: value of number; value: whether been used, doesn't exist if null
        Map<Integer, Boolean> map = new HashMap<>();
        for (int v : a) {
            map.put(v, false);
        }
        for (int v : a) {
            if (map.get(v) == Boolean.FALSE) {
                map.put(v, true);

                Integer r = v + 1;
                while (map.get(r) == Boolean.FALSE) {
                    map.put(r++, true);
                }

                Integer l = v - 1;
                while (map.get(l) == Boolean.FALSE) {
                    map.put(l--, true);
                }
                max = Math.max(max, r - l - 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
    // use union-find, finally find the size of the largest set
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valToIdx.putIfAbsent(nums[i], i);
        }

        UnionFind unionFind = new UnionFind(nums.length);
        for (int v : nums) {
            Integer curr = valToIdx.get(v);
            Integer prev = valToIdx.get(v - 1);
            if (prev != null) {
                unionFind.connect(curr, prev);
            }
            Integer next = valToIdx.get(v + 1);
            if (next != null) {
                unionFind.connect(curr, next);
            }
        }

        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int root = unionFind.root(i);
            ans.merge(root, 1, Integer::sum);
        }
        return ans.values().stream().mapToInt(i -> i).max().getAsInt();
    }

    class UnionFind {
        int n;
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int root(int x) {
            if (parent[x] != x) {
                parent[x] = root(parent[x]);
            }
            return parent[x];
        }

        public void connect(int _x, int _y) {
            int x = root(_x);
            int y = root(_y);
            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else {
                    parent[x] = y;
                    rank[y]++;
                }
            }
        }
    }
 */
