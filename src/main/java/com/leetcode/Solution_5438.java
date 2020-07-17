package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

class Solution_5438 {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] a = bloomDay;
        int n = a.length;
        int[][] c = new int[n][2];
        int L = 0;
        int R = 1;

        // e: day -> idx
        Pair[] A = new Pair[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Pair(a[i], i);
        }
        // sort A
        Arrays.sort(A, Comparator.comparingInt(p -> p.day));

        int ans = 0; // total day
        int total = 0; // total followers
        for (int i = 0; i < n; i++) {
            int day = A[i].day;
            int idx = A[i].idx;
            ans = Math.max(ans, day);

            // _ x x . _
            int left = c[idx][L];
            int right = c[idx][R];
            if (idx - left - 1 >= 0) {
                c[idx - left - 1][R] += right + 1;
            }
            if (idx + right + 1 < n) {
                c[idx + right + 1][L] += left + 1;
            }
            if (left % k + right % k + 1 >= k) {
                ++total;
            }
            if (total == m) {
                return ans;
            }
        }
        return -1;
    }

    static class Pair {
        public int day;
        public int idx;

        Pair(int day, int idx) {
            this.day = day;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "[" + day + ", " + idx + ']';
        }
    }
}