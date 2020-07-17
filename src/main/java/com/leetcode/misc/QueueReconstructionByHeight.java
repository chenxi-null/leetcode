package com.leetcode.misc;
/*
https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/

406. Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person
and k is the number of people in front of this person who have a height greater than or equal to h.
Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

----

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Find k == 0
[7,0], [5,0] -> [5,0] [7,0]

k == 1
maxHeight == 7
[6,1] [7,1] -> [5,0] [7,0] [6,1] [7,1]

k == 2
[5,2]

k == 3

k == 4

 */

import java.util.Arrays;
import java.util.Comparator;

class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null && people.length == 1) {
            return people;
        }

        Arrays.sort(people, Comparator.comparingInt(a -> a[1]));

        int[][] res = new int[people.length][2];

        return null; //todo
    }
}
