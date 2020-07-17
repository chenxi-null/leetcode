package com.leetcode.array;

import java.util.Arrays;

class MergeTwoSortedArray {
    /*
    corner cases:

        m == 0  
    
        n == 0

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

---

 k     i
[-,-,-,1,2,3]
 j
[2,5,6]

       k   i
[1,2,2,1,2,3]
   j
[2,5,6]

         k      i
[1,2,2,3,2,3]
   j
[2,5,6]

---
1 2 5 6 7 * * *
4 8 9

// move spare position in front of numbers in array 1
* * * 1 2 5 6 7
4 8 9

corner cases:
    m == 0
    n == 0
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println();

        int k = 0;
        int i = n;
        int j = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }

            System.out.printf("%d, %d, %d\n", k, i, j);
            print(0, k, nums1);
            print(i, m + n, nums1);
            print(j, n, nums2);

            //System.out.println(Arrays.toString(nums1));
            System.out.println("----");
        }
        while (i < m + n) {
            nums1[k++] = nums1[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }

    private void print(int startIdx, int endIdx, int[] a) {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = startIdx; i < endIdx; i++) {
            b.append(a[i]);
            if (i != endIdx - 1) {
                b.append(',');
            }
        }
        b.append(']');
        System.out.println(b.toString());
    }
}
