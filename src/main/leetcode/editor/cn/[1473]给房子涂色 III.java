//There is a row of m houses in a small city, each house must be painted with on
//e of the n colors (labeled from 1 to n), some houses that has been painted last 
//summer should not be painted again. 
//
// A neighborhood is a maximal group of continuous houses that are painted with 
//the same color. (For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhood
//s [{1}, {2,2}, {3,3}, {2}, {1,1}]). 
//
// Given an array houses, an m * n matrix cost and an integer target where: 
//
// 
// houses[i]: is the color of the house i, 0 if the house is not painted yet. 
// cost[i][j]: is the cost of paint the house i with the color j+1. 
// 
//
// Return the minimum cost of painting all the remaining houses in such a way th
//at there are exactly target neighborhoods, if not possible return -1. 
//
// 
// Example 1: 
//
// 
//Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
//, n = 2, target = 3
//Output: 9
//Explanation: Paint houses of this way [1,2,2,1,1]
//This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
//Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
// 
//
// Example 2: 
//
// 
//Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
//, n = 2, target = 3
//Output: 11
//Explanation: Some houses are already painted, Paint the houses of this way [2,
//2,1,2,2]
//This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}]. 
//Cost of paint the first and last house (10 + 1) = 11.
// 
//
// Example 3: 
//
// 
//Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 
//5, n = 2, target = 5
//Output: 5
// 
//
// Example 4: 
//
// 
//Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n 
//= 3, target = 3
//Output: -1
//Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{
//1},{2},{3}] different of target = 3.
// 
//
// 
// Constraints: 
//
// 
// m == houses.length == cost.length 
// n == cost[i].length 
// 1 <= m <= 100 
// 1 <= n <= 20 
// 1 <= target <= m 
// 0 <= houses[i] <= n 
// 1 <= cost[i][j] <= 10^4 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    /*
    f(h, t, c) = min{
                    min{ f(h-1, t, c)   + ?cost(i,c) },
                    min{ f(h-1, t-1, diff-c) + ?cost(i,dc) | dc~[...] } }
    */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int nh = houses.length;
        int nt = target;
        int nc = n;
        int[][][] dp = new int[nh + 1][nt + 1][nc + 1];
        for (int h = 1; h <= nh; h++) {
            for (int t = 1; t <= nt; t++) {
                for (int c = 1; c <= nc; c++) {
                    dp[h][t][c] = -1;
                }
            }
        }

        for (int h = 1; h <= nh; h++) {
            //System.out.println("\n----- h: " + h + "-----");
            for (int t = 1; t <= nt && t <= h; t++) {
                int curr = houses[h - 1];
                if (curr > 0) { // can't paint
                    int min = Integer.MAX_VALUE;
                    if (dp[h - 1][t][curr] >= 0 || h == 1) {
                        min = dp[h - 1][t][curr];
                    }
                    if (t >= 2) {
                        for (int i = 1; i <= nc; i++) {
                            if (i != curr && dp[h - 1][t - 1][i] >= 0) {
                                min = Math.min(min, dp[h - 1][t - 1][i]);
                            }
                        }
                    }
                    dp[h][t][curr] = (min == Integer.MAX_VALUE ? -1 : min);
                } else { // can paint
                    for (int c = 1; c <= nc; c++) {
                        int min = Integer.MAX_VALUE;
                        // same color, compared with the previous house
                        if (dp[h - 1][t][c] >= 0 || h == 1) {
                            min = dp[h - 1][t][c] + cost[h - 1][c - 1];
                        }
                        // different color, compared with the previous house
                        if (t >= 2) {
                            for (int i = 1; i <= nc; i++) {
                                if (i != c && dp[h - 1][t - 1][i] >= 0) {
                                    min = Math.min(min, dp[h - 1][t - 1][i] + cost[h - 1][c - 1]);
                                }
                            }
                        }
                        dp[h][t][c] = (min == Integer.MAX_VALUE ? -1 : min);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(dp[h]));
        }

        int min = Integer.MAX_VALUE;
        for (int c = 1; c <= nc; c++) {
            if (dp[nh][nt][c] >= 0) {
                min = Math.min(min, dp[nh][nt][c]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
#[WA] misunderstand & use wrong var & wrong var scope of `min`
 */
