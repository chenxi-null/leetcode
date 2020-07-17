package com.leetcode.weekly.weekly191;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/31
 */
public class Solution2 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxHLen = 0;
        int maxWLen = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hSize = horizontalCuts.length;
        for (int i = 0; i <= hSize; i++) {
            int cand;
            if (i == 0) {
                cand = horizontalCuts[0];
            } else if (i == hSize) {
                cand = h - horizontalCuts[i - 1];
            } else {
                cand = horizontalCuts[i] - horizontalCuts[i - 1];
            }
            maxHLen = Math.max(cand, maxHLen);
        }
        int wSize = verticalCuts.length;
        for (int i = 0; i <= wSize; i++) {
            int cand;
            if (i == 0) {
                cand = verticalCuts[0];
            } else if (i == wSize) {
                cand = w - verticalCuts[i - 1];
            } else {
                cand = verticalCuts[i] - verticalCuts[i - 1];
            }
            maxWLen = Math.max(cand, maxWLen);
        }

        int res = BigDecimal.valueOf(maxHLen)
                .multiply(BigDecimal.valueOf(maxWLen))
                .remainder(BigDecimal.valueOf(10_0000_0000 + 7)).intValue();
        return res;
    }
}
