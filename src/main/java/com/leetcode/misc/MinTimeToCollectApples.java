package com.leetcode.misc;

import java.util.List;

//  Minimum Time to Collect All Apples in a Tree
class MinTimeToCollectApples {
    /*
    edges[i]
    edges[i][0] -> edges[i][1]
    a -> b (a < b)
    parent -> child

    if child node has apple, then make parent also have
     */

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int i = edges.length - 1; i >= 0; i--) {
            int parentIdx = edges[i][0];
            int childIdx = edges[i][1];
            if (hasApple.get(childIdx)) {
                hasApple.set(parentIdx, true);
            }
        }

        int count = 0;
        for (int i = 1; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                ++count;
            }
        }
        return 2 * count;
    }
}