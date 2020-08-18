package com.leetcode.weekly.weekly202;

/*
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.


Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
 */
class _1550_Three_Consecutive_Odds {
    public boolean threeConsecutiveOdds(int[] a) {
        int cnt = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                cnt = 0;
            } else {
                cnt++;
                if (cnt >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}