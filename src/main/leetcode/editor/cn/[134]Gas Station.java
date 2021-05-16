//There are n gas stations along a circular route, where the amount of gas at th
//e ith station is gas[i]. 
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to trav
//el from the ith station to its next (i + 1)th station. You begin the journey wit
//h an empty tank at one of the gas stations. 
//
// Given two integer arrays gas and cost, return the starting gas station's inde
//x if you can travel around the circuit once in the clockwise direction, otherwis
//e return -1. If there exists a solution, it is guaranteed to be unique 
//
// 
// Example 1: 
//
// 
//Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//Output: 3
//Explanation:
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4
// = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to 
//station 3.
//Therefore, return 3 as the starting index.
// 
//
// Example 2: 
//
// 
//Input: gas = [2,3,4], cost = [3,4,3]
//Output: -1
//Explanation:
//You can't start at station 0 or 1, as there is not enough gas to travel to the
// next station.
//Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//
//Travel to station 0. Your tank = 4 - 3 + 2 = 3
//Travel to station 1. Your tank = 3 - 3 + 3 = 3
//You cannot travel back to station 2, as it requires 4 unit of gas but you only
// have 3.
//Therefore, you can't travel around the circuit once no matter where you start.
//
// 
//
// 
// Constraints: 
//
// 
// gas.length == n 
// cost.length == n 
// 1 <= n <= 104 
// 0 <= gas[i], cost[i] <= 104 
// 
// Related Topics 贪心算法 
// 👍 638 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
 gas: [ 1,  2,  3,  4,  8,
cost: [ 3,  4,  5,  1,  2,
 get: [-2, -2, -2,  3,  6, -4, 1

e.g.
 3, -2,  3, -2,  1, -2,  1, -2
 3   1   4   2   3   1   2   0

-2, -2, -2,  3,  6, -4, 1
-2  -4  -6  -3   3  -1  0

-2, -2, -2,  3,  6, -4, 1
-2  -4  -6  -3   3  -1  0

----

1. merge into interval
... +++ ___ +++ ___ ...

e.g:
1 -1 1 -1 ...
-6 9 -4 1

+999 -6 +9 -4 +11 -99

-6 +9 -4 +11 -99 +999

3 -2 3 - 2 1 -2 1 -2

 */