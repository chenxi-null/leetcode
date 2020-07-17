package com.leetcode.twopointers;
/*
https://leetcode-cn.com/problems/find-the-celebrity/
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
class Relation {
    boolean knows(int a, int b) {
        return true;
    }
}

public class FindCelebrity extends Relation {

    /*
    Definition:
    - anyone knows celebrity
    - celebrity doesn't know anyone but himself/herself

    ---

    1. find candidate
              q <- p
              |
    a -> b -> c <- x     m -> f
    ^    |    ^          |____|
    |____|    |
              y

    2. verify this candidate (only one celebrity and more than one fake)
        - anyone knows him
        - him doesn't know anyone but himself

    corner cases:
        - anyone knows candidate, but he knows someone who isn't himself

   ---

       0  1  2
    0 [1, 0, 1]
    1 [1, 1, 0]
    2 [0, 1, 1]
     */
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }

        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!knows(i, candidate)
                    || (knows(candidate, i) && candidate != i)) {
                return -1;
            }
        }
        return candidate;
    }
}


//----------------------------------------------------

    /*
      0 1 2 3 4 5
    -------------
  0 | 1 x x x x x
  1 | x 1 x x x x
  2 | x x 1 x x x
  3 | x x x 1 x x
  4 | x x x x 1 x
  5 | x x x x x 1

    [1,0,1,0],
    [1,1,0,0],
    [0,1,1,0]
    [0,1,1,1]

      0 1 2 3 4 5
    -------------
  0 | - 1 1 1 1 x
  1 | x - 0 1 1 x
  2 | x x - 0 1 x
  3 | x x x - x x
  4 | x x x x - x
  5 | x x x x x -
   */
