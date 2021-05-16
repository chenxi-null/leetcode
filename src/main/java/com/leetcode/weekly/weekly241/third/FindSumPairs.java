package com.leetcode.weekly.weekly241.third;

import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    Map<Integer, Integer> numToCountMap = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) {
            if (!numToCountMap.containsKey(num)) {
                numToCountMap.put(num, 1);
            } else {
                numToCountMap.put(num, numToCountMap.get(num) + 1);
            }
        }
    }
    
    public void add(int index, int val) {
        int origNum = nums2[index];
        int newNum = nums2[index] + val;
        nums2[index] += val;

        numToCountMap.put(origNum, numToCountMap.get(origNum) - 1);
        numToCountMap.put(newNum, numToCountMap.getOrDefault(newNum, 0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for (int num1 : nums1) {
            int d = tot - num1;
            if (numToCountMap.containsKey(d)) {
                ans += numToCountMap.get(d);
            }
        }
        return ans;
    }
}
/*
m * n

 */

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

