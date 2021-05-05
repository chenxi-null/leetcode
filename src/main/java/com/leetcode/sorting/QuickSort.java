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
        int pivotIdx = select(a, start, end);
        swap(a, pivotIdx, start);
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

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int select(int[] a, int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }
}
