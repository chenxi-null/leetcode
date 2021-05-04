//The gray code is a binary numeral system where two successive values differ in
// only one bit. 
//
// Given an integer n representing the total number of bits in the code, return 
//any sequence of gray code. 
//
// A gray code sequence must begin with 0. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,3,2]
//Explanation:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//[0,2,3,1] is also a valid gray code sequence.
//00 - 0
//10 - 2
//11 - 3
//01 - 1
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 16 
// 
// Related Topics 回溯算法 
// 👍 287 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer> list = grayCode(n - 1);
        int offset = (int) Math.pow(2, n - 1);
        int lastSize = list.size();
        for (int i = lastSize - 1; i >= 0; i--) {
            list.add(list.get(i) + offset);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
n      0, 1, 2
count  0  2  4

       0  0  00
          1  01
             11
             10

000, 001, 010, 011, 111, 110, 100
0     1    2    3    7    6    4
 */