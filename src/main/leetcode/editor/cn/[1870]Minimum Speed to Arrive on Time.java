//You are given a floating-point number hour, representing the amount of time yo
//u have to reach the office. To commute to the office, you must take n trains in
//sequential order. You are also given an integer array dist of length n, where di
//st[i] describes the distance (in kilometers) of the ith train ride.
//
// Each train can only depart at an integer hour, so you may need to wait in bet
//ween each train ride.
//
//
// For example, if the 1st train ride takes 1.5 hours, you must wait for an addi
//tional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
//
//
//
// Return the minimum positive integer speed (in kilometers per hour) that all t
//he trains must travel at for you to reach the office on time, or -1 if it is imp
//ossible to be on time.
//
// Tests are generated such that the answer will not exceed 107 and hour will ha
//ve at most two digits after the decimal point.
//
//
// Example 1:
//
//
//Input: dist = [1,3,2], hour = 6
//Output: 1
//Explanation: At speed 1:
//- The first train ride takes 1/1 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 1 hour
// mark. The second train takes 3/1 = 3 hours.
//- Since we are already at an integer hour, we depart immediately at the 4 hour
// mark. The third train takes 2/1 = 2 hours.
//- You will arrive at exactly the 6 hour mark.
//
//
// Example 2:
//
//
//Input: dist = [1,3,2], hour = 2.7
//Output: 3
//Explanation: At speed 3:
//- The first train ride takes 1/3 = 0.33333 hours.
//- Since we are not at an integer hour, we wait until the 1 hour mark to depart
//. The second train ride takes 3/3 = 1 hour.
//- Since we are already at an integer hour, we depart immediately at the 2 hour
// mark. The third train takes 2/3 = 0.66667 hours.
//- You will arrive at the 2.66667 hour mark.
//
//
// Example 3:
//
//
//Input: dist = [1,3,2], hour = 1.9
//Output: -1
//Explanation: It is impossible because the earliest the third train can depart
//is at the 2 hour mark.
//
//
//
// Constraints:
//
//
// n == dist.length
// 1 <= n <= 105
// 1 <= dist[i] <= 105
// 1 <= hour <= 109
// There will be at most two digits after the decimal point in hour.
//
// Related Topics 数学 二分查找
// 👍 9 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        //int max = -1;
        //for (int d : dist) {
        //    max = Math.max(max, d);
        //    min = Math.min(max, d);
        //}
        if (hour - (n - 1) <= 0) return -1;
        //int candMax = Math.celling(dist[n - 1] / (hour - n + 1));
        //max = Math.max(max, candMax);
        int l = 1;
        int r = 10_000_000;
        while (l <= r) {
            int mid = l + r / 2;

            double midVal = 0.0;
            for (int i = 0; i < n - 1; i++) {
                midVal += Math.ceil(((double) dist[i]) / mid);
            }
            midVal += ((double) dist[n - 1]) / mid;

            //System.out.println("[" + l + ", " + r + "]" + " " + mid + " | " + midVal);

            if (midVal < hour) {
                r = mid - 1;
            } else if (midVal > hour) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
