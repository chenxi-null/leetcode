package com.leetcode;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

https://leetcode-cn.com/problems/jump-game
 */

 /*
解题思路

分析：
起点的序号为 0，设终点的序号为 dest

"能从起点跳到终点", 等价于 "在起点和终点之前至少存在一个点，可以直接一步跳到终点", 设这个点的序号为 m

原始命题等价于 "能从起点跳到 m 点"。

要证明上述两个命题等价，需要证明原始命题是后者的充分必要条件:
1. 证明必要性：显然，如果能从起点到 m 点，m 可以一步跳到终点，那么从起点就可以跳到终点
2. 证明充分性: 如果能从起点跳到终点，那么从起点就可以跳到所有的点，其中就包括 m 点

步骤：
从 dest 开始，从后往前找 m 点，
- 如果找不过说明到达不了终点，
- 如果找了满足条件的 m 点，那么就把 m 点设为 dest，开始下一轮循环，直到 m 变成 0 为止。
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/2/22
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int destIdx = nums.length - 1;
        if (destIdx == 0) {
            return true;
        }

        while (true) {
            boolean found = false;
            for (int i = destIdx - 1; i >= 0; i--) {
                boolean canJump = nums[i] >= (destIdx - i);
                if (canJump) {
                    destIdx = i;
                    found =true;
                }
            }
            if (!found) return false;
            if (destIdx == 0) return true;
        }
    }
}
