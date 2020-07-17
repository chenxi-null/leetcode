package com.leetcode.array;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] a = nums;
        int n = a.length;

        // find the position of a target
        int left = 0;
        int right = n - 1;
        int t_idx = 0;
        boolean found = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] < target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                t_idx = mid;
                found = true;
                break;
            }
        }
        if (!found) {
            return new int[]{-1, -1};
        }

        int ans_left = findLeftIndex(left, t_idx, a, target);
        int ans_right = findRightIndex(t_idx, right, a, target);
        return new int[]{ans_left, ans_right};
    }

    // find for left  [.... t]
    @SneakyThrows
    private int findLeftIndex(int left, int right, int[] a, int target) {
        System.out.println("Solution.findLeftIndex");
        while (left < right) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("left = " + left + ", right = " + right);
            if (a[left] == a[right]) {
                return left;
            }
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // exit condition: left == right
        return left;
    }

    // find for right [t ....]
    @SneakyThrows
    private int findRightIndex(int left, int right, int[] a, int target) {
        System.out.println("Solution.findRightIndex");
        while (left < right) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("left = " + left + ", right = " + right);
            if (a[left] == a[right]) {
                return right;
            }
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}