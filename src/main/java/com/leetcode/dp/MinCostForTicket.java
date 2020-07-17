package com.leetcode.dp;
/*
983. Minimum Cost For Tickets
In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.



Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.


Note:

1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/7
 */
public class MinCostForTicket {

    /*
    c[i]: min cost from 1 to (i+1)th day

    c[i] =
        if (occupied[i])
            min{ c[i - 1] + costs[0], c[i - 7] + costs[1], c[i - 30] + costs[2] }
        else
            c[i - 1]
     */
    public int mincostTickets(int[] days, int[] costs) {
        int totalDay = 365;
        int[] minCosts = new int[totalDay];

        boolean[] occupiedDays = new boolean[totalDay];
        for (int day : days) {
            occupiedDays[day - 1] = true;
        }

        for (int i = 0; i < totalDay; i++) {
            if (occupiedDays[i]) {
                int t = i - 1 >= 0 ? minCosts[i - 1] : 0;
                int min = t + costs[0];

                t = i - 7 >= 0 ? minCosts[i - 7] : 0;
                min = Math.min(min, t + costs[1]);

                t = i - 30 >= 0 ? minCosts[i - 30] : 0;
                min = Math.min(min, t + costs[2]);

                minCosts[i] = min;
            } else {
                if (i - 1 >= 0) {
                    minCosts[i] = minCosts[i - 1];
                } else {
                    minCosts[i] = 0;
                }
            }
        }
        return minCosts[totalDay - 1];
    }
}
