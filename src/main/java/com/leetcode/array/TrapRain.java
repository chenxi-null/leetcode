package com.leetcode.array;
/*
https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 */

public class TrapRain {
    /*

                 -
         -       -
         - -   - -
         - - - - - - -
level:   0 3 3 3 0 4 4

        -     -
        - -   -
        - - - -
     */
    public int trap(int[] height) {
        if (null == height || height.length <= 2) {
            return 0;
        }

        int[] leftLevels = new int[height.length];
        int[] rightLevels = new int[height.length];

        int maxLevel = 0;
        for (int i = 0; i < leftLevels.length; i++) {
            if (height[i] >= maxLevel) {
                leftLevels[i] = 0;
                maxLevel = height[i];
            } else {
                leftLevels[i] = maxLevel;
            }
        }

        maxLevel = 0;
        for (int i = rightLevels.length - 1; i >= 0; i--) {
            if (height[i] >= maxLevel) {
                rightLevels[i] = 0;
                maxLevel = height[i];
            } else {
                rightLevels[i] = maxLevel;
            }
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int lvl = Math.min(leftLevels[i], rightLevels[i]);
            if (lvl > height[i]) {
                sum += lvl - height[i];
            }
        }
        return sum;
    }
}