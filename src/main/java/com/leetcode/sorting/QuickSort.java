package com.leetcode.sorting;

import java.util.Random;

/**
 * @author chenxi20
 * @date 2021/5/5
 */
public class QuickSort {

    private Random random = new Random();

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(a, start, end);
        quickSort(a, start, mid - 1);
        quickSort(a, mid + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int randomIdx = random.nextInt(end - start + 1) + start;
        swap(a, randomIdx, end);

        int x = a[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (a[j] < x) {
                swap(a, ++i, j);
            }
        }
        // a[idx <= i] < x;
        // a[idx > i] >= x;
        swap(a, i + 1, end);
        return i + 1;
    }

    //----------------------------------------------------

    private int partition_0505(int[] a, int start, int end) {
        int idx = random.nextInt(end - start + 1) + start;
        swap(a, idx, start);

        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right && a[left] <= a[start]) ++left;
            while (left < right && a[right] >= a[start]) --right;
            if (left < right) {
                swap(a, left, right);
                ++left;
                --right;
            }
        }
        if (left == right && a[right] > a[start]) {
            --right;
        }
        swap(a, right, start);
        return right;
    }

    //----------------------------------------------------

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
