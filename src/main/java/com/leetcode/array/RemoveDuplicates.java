package com.leetcode.array;

/*
Given nums =
[0,0,1,1,1,2,2,3,3,4],

|    |    |
[0,1,2,2, 2,3,3,4],
     i    j

     -      -
[0,1,2,2, 2,3,3,4],
     i      j

i   j          i   j
a a b x x -> a b a x x x

i j
a b

       -      -
[0,1,2,2, 2,3,3,4],
       i      j
 */

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 1) {
            return nums.length;
        }

        int i = 0; // the index of last unique number
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j > i + 1) {
                    int t = nums[j];
                    nums[j] = nums[i + 1];
                    nums[i + 1] = t;
                }
                i++;
            }
        }
        return i + 1;
    }
}