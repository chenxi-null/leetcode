//There are a total of n courses you have to take labelled from 0 to n - 1. 
//
// Some courses may have prerequisites, for example, if prerequisites[i] = [ai, 
//bi] this means you must take the course bi before the course ai. 
//
// Given the total number of courses numCourses and a list of the prerequisite p
//airs, return the ordering of courses you should take to finish all courses. 
//
// If there are many valid answers, return any of them. If it is impossible to f
//inish all courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 392 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int n, int[][] p) {
        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> conn = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int from = p[i][0];
            int to = p[i][1];
            if (conn.get(from) == null) {
                conn.put(from, new ArrayList<>());
            }
            conn.get(from).add(to);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                boolean r = dfs(i, conn, visited, ans);
                if (!r) {
                    return new int[]{};
                }
            }
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    //todo: need three var to represent state of visited
    private boolean dfs(int r, Map<Integer, List<Integer>> conn, int[] visited, List<Integer> ans) {
        visited[r] = 1;
        List<Integer> nodes = conn.get(r);
        if (nodes != null && !nodes.isEmpty()) {
            for (Integer node : nodes) {
                if (visited[node] > 0) {
                    return false;
                }
                boolean valid = dfs(node, conn, visited, ans);
                if (!valid) {
                    return false;
                }
            }
        }
        ans.add(r);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
